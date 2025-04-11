package service;

import dto.FabricanteDTO;
import dto.FabricanteResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Fabricante;
import repository.FabricanteRepository;

import java.util.List;

@ApplicationScoped
public class FabricanteServiceImpl implements FabricanteService {
    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    @Transactional
    public FabricanteResponseDTO create(FabricanteDTO dto) {
        Fabricante novoFabricante = new Fabricante();
        novoFabricante.setNome(dto.nome());
        novoFabricante.setPais(dto.pais());

        fabricanteRepository.persist(novoFabricante);
        return FabricanteResponseDTO.valueOf(novoFabricante);
    }

    @Override
    @Transactional
    public void update(long id, FabricanteDTO dto) {
        Fabricante edicaoFabricante = fabricanteRepository.findById(id);

        edicaoFabricante.setNome(dto.nome());
        edicaoFabricante.setPais(dto.pais());
    }

    @Override
    @Transactional
    public void delete(long id) {
        fabricanteRepository.deleteById(id);
    }

    @Override
    public FabricanteResponseDTO findById(long id) {
        return FabricanteResponseDTO.valueOf(fabricanteRepository.findById(id));
    }

    @Override
    public List<FabricanteResponseDTO> findAll() {
        return fabricanteRepository.findAll().stream().map(e -> FabricanteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<FabricanteResponseDTO> findByNome(String nome) {
        return fabricanteRepository.findByNome(nome).stream().map(e -> FabricanteResponseDTO.valueOf(e)).toList();
    }
}
