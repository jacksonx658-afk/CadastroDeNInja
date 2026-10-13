package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // listar ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninja = ninjaRepository.findAll();
        return ninja.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // listar ninjas por id
    public NinjaDTO listarNinjasPorId(Long id){
        Optional<NinjaModel> NinjaporId = ninjaRepository.findById(id);
        return NinjaporId.map(ninjaMapper::map).orElse(null);
    }

    // listar ninjas maiores de 18 anos

    public List<NinjaDTO> listarNinjasMaioresDe18Anos(){
        List<NinjaModel> ninjaMaiores = ninjaRepository.findAll();
        return ninjaMaiores.stream()
                .filter(ninjaModel -> ninjaModel.getIdade() >= 18)
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
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

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }


}
