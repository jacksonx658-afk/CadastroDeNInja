package dev.java10x.CadastrosDeNinjas.Missoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -- Mandar uma requisição para mostrar missões

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    // POST -- Mandar uma requisição para criar as missões

    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return missoesService.criarMissao(missoes);
    }

    // PUT -- Mandar uma requisição para alterar as missões

    @PutMapping("/alterar/{id}")
    public MissoesModel atualizarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesService.atualizarMissao(id,missaoAtualizada);
    }

    // DELETE -- Mandar uma requisição para deletar as missões

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }

    // DELETE -- Mandar uma requisição para deletar as missões
}


