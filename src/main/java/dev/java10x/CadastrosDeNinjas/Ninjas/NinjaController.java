package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // READ

    @GetMapping("/listar")
    public List<NinjaModel> listaNinjas(){
        return ninjaService.listarNinjas();
    }

    // CREATE

    @PostMapping("/criar")
    public NinjaModel criarNinjas(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinjas(ninja);
    }

    // READ

    @GetMapping("/listar/{id}")
    public NinjaModel ListarNijasporId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    // UPADATE

    @PutMapping("/alterar/{id}")
    public NinjaModel atualizarNija(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id,ninjaAtualizado);
    }

    // DELETE

    @DeleteMapping("/deletar/{id}")
    public void DeletarNijasPorId(@PathVariable Long id){
        ninjaService.DeletarNijasPorId(id);

    }
}
