package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // listar ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // listar ninjas por id
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> NinjaporId = ninjaRepository.findById(id);
        return NinjaporId.orElse(null);
    }

    // criar ninja
    public NinjaDTO criarNinjas(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);

    }

    // deletar ninja - Tem quer ser um método VOID

    public void DeletarNijasPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    // atualizar ninjas

    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
