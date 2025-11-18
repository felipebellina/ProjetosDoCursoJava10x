package de.java10x.EventClean.infrastructure.persistence;

import de.java10x.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record Evento(
        Long id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String local,
        String organizador,
        TipoEvento tipo
){}
