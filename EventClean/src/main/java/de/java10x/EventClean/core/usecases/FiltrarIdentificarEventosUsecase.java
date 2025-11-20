package de.java10x.EventClean.core.usecases;

import de.java10x.EventClean.core.entities.Evento;

public interface FiltrarIdentificarEventosUsecase {

    public Evento execute(String identificador);

}
