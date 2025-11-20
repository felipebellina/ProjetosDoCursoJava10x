package de.java10x.EventClean.core.gateway;

import de.java10x.EventClean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    Evento criarEvento(Evento evento);

    List<Evento> buscarEvento();

    boolean existePorIdentificador(String identificador);

    Optional<Evento> filtrarPorIdentificador(String identificador);

}
