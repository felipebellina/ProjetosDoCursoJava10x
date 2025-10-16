package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/adicionar")
    public String criarNinja() {
        return "Ninja criado";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId() {
        return "Mostrar Ninja por id";
    }

    @PutMapping("/alterarID")
    public String alterarNinjaPorId () {
        return "Alterar ninja por id";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId () {
        return "Deletar ninja por Id";
    }


}