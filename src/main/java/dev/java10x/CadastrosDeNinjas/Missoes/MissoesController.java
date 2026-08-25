package dev.java10x.CadastrosDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController("/missoes")
public class MissoesController {

    // GET -- Mandar uma requisição para mostrar missões

    @GetMapping("/listar")
    public String ListarMissao(){
        return "Missões listadas com sucesso";
    }

    // POST -- Mandar uma requisição para criar as missões

    @PostMapping("/criar")
    public String CriaMissao(){
        return "Missão criada com sucesso";
    }

    // PUT -- Mandar uma requisição para alterar as missões

    @PutMapping("/alterar")
    public String AlterarMissao(){
        return "Missão alterada com sucesso";
    }

    // DELETE -- Mandar uma requisição para deletar as missões

    @DeleteMapping("/deletar")
    public String DeletarMissoes(){
        return "Missão deletada com sucesso";
    }
}


