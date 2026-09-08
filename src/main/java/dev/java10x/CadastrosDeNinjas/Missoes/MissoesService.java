package dev.java10x.CadastrosDeNinjas.Missoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MissoesService {

    MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }


    // listar missoes por id
    public MissoesModel listarMissaoPorId(Long id){
        Optional<MissoesModel> MissoesporId = missoesRepository.findById(id);
        return MissoesporId.orElse(null);
    }

    // criar missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);

    }

    // deletar missao - Tem quer ser um método VOID

    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    // atualizar missao

    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada){
        if (missoesRepository.existsById(id)) {
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }

}
