package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // listar ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // listar ninjas por id
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> NinjaporId = ninjaRepository.findById(id);
        return  NinjaporId.orElse(null);
    }

    // criar ninja
    public NinjaModel criarNinjas(NinjaModel ninja){
        return ninjaRepository.save(ninja);

    }
}
