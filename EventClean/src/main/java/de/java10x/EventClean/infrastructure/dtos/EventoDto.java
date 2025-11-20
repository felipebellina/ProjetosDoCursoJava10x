package de.java10x.EventClean.infrastructure.dtos;

import de.java10x.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record EventoDto(Long id,
                        String nome,
                        String descricao,
                        String identificador,
                        LocalDateTime dataInicio,
                        LocalDateTime dataFim,
                        String localEvento,
                        Integer capacidade,
                        String organizador,
                        TipoEvento tipo) {
}
