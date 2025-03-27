package service;
import dto.GpuDTO;
import dto.GpuResponseDTO;
import java.util.List;

public interface GpuService {
    GpuResponseDTO createGpu(GpuDTO gpu);
    void updateGpu(long id, GpuDTO gpu);
    void deleteGpu(long id);
    GpuResponseDTO findById(long id);
    GpuResponseDTO findByName(String name);
    List<GpuResponseDTO> findAll();
}
