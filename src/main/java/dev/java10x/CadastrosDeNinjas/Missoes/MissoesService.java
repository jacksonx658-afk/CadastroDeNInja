package dev.java10x.CadastrosDeNinjas.Missoes;

import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastrosDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class MissoesService {

    MissoesRepository missoesRepository;
    MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // listar missoes
    public List<MissoesDTO> listarMissoes() {
        return missoesRepository.findAll()
                .stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // listar missao por id
    public MissoesDTO listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    // criar missao
    public MissoesDTO criarMissao(MissoesDTO missoesDTO) {
        MissoesModel missao = missoesMapper.map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    // atualizar missao
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO) {
        if (missoesRepository.existsById(id)) {
            MissoesModel missao = missoesMapper.map(missoesDTO);
            missao.setId(id);
            missao = missoesRepository.save(missao);
            return missoesMapper.map(missao);
        }
        return null;
    }

    // deletar missao - tem que ser um método VOID
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }
}