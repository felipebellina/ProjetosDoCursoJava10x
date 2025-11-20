package de.java10x.EventClean.core.usecases;

import de.java10x.EventClean.core.entities.Evento;

import java.util.List;

public interface BuscarEventoUsecase {

    public List<Evento> execute();

}
