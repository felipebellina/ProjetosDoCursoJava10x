package dev.java.ecommerce.basketservice.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String ex) {
        super(ex);
    }
}
