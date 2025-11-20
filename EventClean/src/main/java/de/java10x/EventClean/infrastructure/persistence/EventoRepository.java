package de.java10x.EventClean.infrastructure.persistence;

import de.java10x.EventClean.core.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {

    Optional<Evento> findByidentificador(String identificador);

}
