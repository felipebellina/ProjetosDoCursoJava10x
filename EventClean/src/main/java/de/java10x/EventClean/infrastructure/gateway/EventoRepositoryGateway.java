package de.java10x.EventClean.infrastructure.gateway;

import de.java10x.EventClean.core.entities.Evento;
import de.java10x.EventClean.core.gateway.EventoGateway;
import de.java10x.EventClean.infrastructure.mapper.EventoEntityMapper;
import de.java10x.EventClean.infrastructure.persistence.EventoEntity;
import de.java10x.EventClean.infrastructure.persistence.EventoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository eventoRepository;
    private final EventoEntityMapper eventoEntityMapper;

    public EventoRepositoryGateway(EventoRepository eventoRepository, EventoEntityMapper eventoEntityMapper) {
        this.eventoRepository = eventoRepository;
        this.eventoEntityMapper = eventoEntityMapper;
    }


    @Override
    public Evento criarEvento(Evento evento) {

        EventoEntity eventoEntity = eventoEntityMapper.toEntity(evento);
        EventoEntity novoEvento = eventoRepository.save(eventoEntity);

        return eventoEntityMapper.toDomain(novoEvento);

    }

    @Override
    public List<Evento> buscarEvento() {
        return eventoRepository.findAll().stream().map(eventoEntityMapper::toDomain).toList();
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return eventoRepository.findAll().stream().anyMatch(evento -> evento.getIdentificador().equalsIgnoreCase(identificador));
    }

    @Override
    public Optional<Evento> filtrarPorIdentificador(String identificador) {
        return eventoRepository.findByidentificador(identificador);
    }

}
