package service;

import dto.ManufacturerDTO;
import dto.ManufacturerResponseDTO;

import java.util.List;

public interface ManufacturerService {

    ManufacturerResponseDTO create(ManufacturerDTO Manufacturer);
    void update(long id, ManufacturerDTO Manufacturer);
    void delete(long id);
    ManufacturerResponseDTO findById(long id);
    List<ManufacturerResponseDTO> findByNome(String nome);
    List<ManufacturerResponseDTO> findAll();
}
