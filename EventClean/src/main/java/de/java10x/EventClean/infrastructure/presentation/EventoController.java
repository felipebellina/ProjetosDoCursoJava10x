package de.java10x.EventClean.infrastructure.presentation;

import de.java10x.EventClean.core.entities.Evento;
import de.java10x.EventClean.core.usecases.BuscarEventoUsecase;
import de.java10x.EventClean.core.usecases.CriarEventoUsecase;
import de.java10x.EventClean.core.usecases.FiltrarIdentificarEventosUsecase;
import de.java10x.EventClean.infrastructure.dtos.EventoDto;
import de.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class EventoController {

    private final CriarEventoUsecase criarEventoCase;
    private final EventoDtoMapper eventoDtoMapper;
    private final BuscarEventoUsecase buscarEventoUsecase;
    private final FiltrarIdentificarEventosUsecase filtrarIdentificarEventosUsecase;

    public EventoController(CriarEventoUsecase criarEventoCase, EventoDtoMapper eventoDtoMapper, BuscarEventoUsecase buscarEventoUsecase, FiltrarIdentificarEventosUsecase filtrarIdentificarEventosUsecase) {
        this.criarEventoCase = criarEventoCase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUsecase = buscarEventoUsecase;
        this.filtrarIdentificarEventosUsecase = filtrarIdentificarEventosUsecase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String,Object>> criarEvento(@RequestBody EventoDto eventoDto) {

        Evento novoEvento = criarEventoCase.execute(eventoDtoMapper.toDomain(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem:", "Evento cadastrado com sucesso no nosso banco de dados");
        response.put("Dados do evento: ", eventoDtoMapper.toDto(novoEvento));

        return ResponseEntity.ok(response);

    }

    @GetMapping("buscarevento")
    public List<EventoDto> buscarEventos() {
        return buscarEventoUsecase.execute().stream().map(eventoDtoMapper::toDto).toList();
    }

    @GetMapping("/identificador/{identificador}")
    public ResponseEntity<Evento> buscarPorIdentificador(@PathVariable String identificador) {
        Evento evento = filtrarIdentificarEventosUsecase.execute(identificador);
        return ResponseEntity.ok(evento);
    }


}
