package dev.java.ecommerce.basketservice.service;

import dev.java.ecommerce.basketservice.client.PlatziProductResponse;
import dev.java.ecommerce.basketservice.controller.BasketController;
import dev.java.ecommerce.basketservice.controller.request.BasketRequest;
import dev.java.ecommerce.basketservice.controller.request.PaymentRequest;
import dev.java.ecommerce.basketservice.controller.request.ProductRequest;
import dev.java.ecommerce.basketservice.entity.Basket;
import dev.java.ecommerce.basketservice.entity.Product;
import dev.java.ecommerce.basketservice.entity.Status;
import dev.java.ecommerce.basketservice.exceptions.BusinessException;
import dev.java.ecommerce.basketservice.exceptions.DataNotFoundException;
import dev.java.ecommerce.basketservice.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;

    public Basket getBasketById(String id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Basket not found"));
    }

    public Basket createBasket(BasketRequest basketRequest) {
        basketRepository.findByClientAndStatus(basketRequest.clientId(), Status.OPEN).ifPresent(basket -> {
                    throw new BusinessException("");
                });

        List<Product> products = getProducts(basketRequest);
        Basket basket = Basket.builder()
                .client(basketRequest.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);

    }

    public Basket updateBasket(String basketId, BasketRequest request) {
        Basket basket = getBasketById(basketId);

        List<Product> products = getProducts(request);

        basket.setProducts(products);
        basket.calculateTotalPrice();

        return basketRepository.save(basket);

    }

    public Basket payBasket(String basketId, PaymentRequest request) {
        Basket basket = getBasketById(basketId);
        basket.setPaymentMethod(request.getPaymentMethod());
        basket.setStatus(Status.SOLD);
        return basketRepository.save(basket);
    }

    public void deleteBasket(String id) {
        basketRepository.delete(getBasketById(id));
    }

    private List<Product> getProducts(BasketRequest basketRequest) {
        List<Product> products = new ArrayList<>();
        basketRequest.products().forEach(product -> {
            PlatziProductResponse platziProductResponse = productService.getProductById(product.id());

            products.add(Product.builder()
                    .id(platziProductResponse.id())
                    .title(platziProductResponse.title())
                    .price(platziProductResponse.price())
                    .quantity(product.quantity())
                    .build());
        });
        return products;
    }

}
