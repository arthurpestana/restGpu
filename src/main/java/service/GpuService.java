package service;
import java.util.List;

import dto.GpuDTO;
import dto.GpuResponseDTO;

public interface GpuService {
    GpuResponseDTO create(GpuDTO gpu);
    void update(long id, GpuDTO gpu);
    void delete(long id);
    GpuResponseDTO findById(long id);
    List<GpuResponseDTO> findByNome(String nome);
    List<GpuResponseDTO> findAll();
    List<GpuResponseDTO> findByFabricante(long idFabricante);
}
