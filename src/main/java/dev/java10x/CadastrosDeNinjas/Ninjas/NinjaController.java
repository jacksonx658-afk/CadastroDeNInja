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

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
        }

    // READ

    @GetMapping("/listar")
    public List<NinjaModel> listaNinjas(){
        return ninjaService.listarNinjas();
    }

    // CREATE

    @PostMapping("/criar")
    public String CriarNinja(){
        return "Ninjas criado";
    }

    // READ

    @GetMapping("/listar/{id}")
    public NinjaModel ListarNijasporId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    // UPADATE

    @PutMapping("/alterarID")
    public String AlterarNijas(){
        return "Alterar Ninjas por ID";
    }

    // DELETE

    @DeleteMapping("/deletarID")
    public String DeletarNijas(){
        return "Deletar Ninjas por ID";
    }
}
