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
    public List<NinjaDTO> listaNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO ListarNinjasporId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    @GetMapping("/listarMaiorque18")
    public List<NinjaDTO> listarNinjasMaioresDe18Anos(){
        return ninjaService.listarNinjasMaioresDe18Anos();
    }

    // CREATE

    @PostMapping("/criar")
    public NinjaDTO criarNinjas(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinjas(ninja);
    }

    // UPADATE

    @PutMapping("/alterar/{id}")
    public NinjaDTO atualizarNija(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id,ninjaAtualizado);
    }

    // DELETE

    @DeleteMapping("/deletar/{id}")
    public void DeletarNijasPorId(@PathVariable Long id){
        ninjaService.DeletarNijasPorId(id);

    }
}
