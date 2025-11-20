package de.java10x.EventClean.core.usecases;

import de.java10x.EventClean.core.entities.Evento;
import de.java10x.EventClean.core.gateway.EventoGateway;
import de.java10x.EventClean.infrastructure.exception.DuplicateEventException;
import de.java10x.EventClean.infrastructure.exception.NotFoundEventException;

public class FiltrarIdentificadorEventoUsecaseImpl implements FiltrarIdentificarEventosUsecase {

    private final EventoGateway eventoGateway;

    public FiltrarIdentificadorEventoUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtrarPorIdentificador(identificador)
                .orElseThrow(() -> new NotFoundEventException("Evento com identificador: " + identificador + " não encontrado"));
    }
}


