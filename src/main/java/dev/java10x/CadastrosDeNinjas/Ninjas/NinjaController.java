package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
        }

    // READ

    @GetMapping("/listar")
    public String MostarNinjas(){
        return "Mostrar Ninjas";
    }

    // CREATE

    @PostMapping("/criar")
    public String CriarNinja(){
        return "Ninjas criado";
    }

    // READ

    @GetMapping("/listarID")
    public String MostarNijasporID(){
        return "Mostrar Ninjas por ID";
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
