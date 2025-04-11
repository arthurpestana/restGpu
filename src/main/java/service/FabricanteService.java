package service;

import dto.FabricanteDTO;
import dto.FabricanteResponseDTO;

import java.util.List;

public interface FabricanteService {

    FabricanteResponseDTO create(FabricanteDTO Fabricante);
    void update(long id, FabricanteDTO Fabricante);
    void delete(long id);
    FabricanteResponseDTO findById(long id);
    List<FabricanteResponseDTO> findByNome(String nome);
    List<FabricanteResponseDTO> findAll();
}
