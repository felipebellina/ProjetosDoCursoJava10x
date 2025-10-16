package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada";
    }

    @GetMapping("/todas")
    public String mostrarTodasMissoes() {
        return "Mostrar Missão";
    }

    @GetMapping("/GetPorId")
    public String mostrarTodasMissoesPorId() {
        return "Mostrar Missão por id";
    }

    @PutMapping("/alterarPorID")
    public String alterarMissaoPorId () {
        return "Alterar missão por id";
    }

    @DeleteMapping("/deletarPorID")
    public String deletarMissaoPorId () {
        return "Deletar missão por Id";
    }

}
