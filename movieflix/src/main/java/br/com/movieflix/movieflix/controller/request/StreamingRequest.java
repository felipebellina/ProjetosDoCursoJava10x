package br.com.movieflix.movieflix.controller.request;

import br.com.movieflix.movieflix.controller.response.StreamingResponse;
import br.com.movieflix.movieflix.entity.Streaming;
import br.com.movieflix.movieflix.service.StreamingService;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotEmpty(message = "Nome do serviço de streaming é obrigatório") String name) {
}
