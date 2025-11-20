package de.java10x.EventClean.core.usecases;

import de.java10x.EventClean.core.entities.Evento;
import de.java10x.EventClean.core.gateway.EventoGateway;
import de.java10x.EventClean.infrastructure.exception.DuplicateEventException;

public class CriarEventoUsecaseImpl implements CriarEventoUsecase {

    private final EventoGateway eventoGateway;

    public CriarEventoUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {




        if (eventoGateway.existePorIdentificador(evento.identificador())) {
            throw new DuplicateEventException("O identificador número: " + evento.identificador() + " já está em uso.");
        }

        return eventoGateway.criarEvento(evento);
    }
}


