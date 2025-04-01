package service;

import dto.GpuDTO;
import dto.GpuResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Gpu;
import repository.GpuRepository;

import java.util.List;

@ApplicationScoped
public class GpuServiceImpl implements GpuService {

    @Inject
    GpuRepository gpuRepository;

    @Override
    @Transactional
    public GpuResponseDTO createGpu(GpuDTO gpu) {
        Gpu novaGpu = new Gpu();
        novaGpu.setNome(gpu.nome());
        novaGpu.setFabricante(gpu.fabricante());
        novaGpu.setMemoriaVRAM(gpu.memoriaVRAM());
        novaGpu.setTipo(gpu.tipo());
        novaGpu.setArquitetura(gpu.arquitetura());

        gpuRepository.persist(novaGpu);

        return GpuResponseDTO.valueOf(novaGpu);
    }

    @Override
    @Transactional
    public void updateGpu(long id, GpuDTO gpu) {
        Gpu gpuExistente = gpuRepository.findById(id);

        gpuExistente.setNome(gpu.nome());
        gpuExistente.setFabricante(gpu.fabricante());
        gpuExistente.setMemoriaVRAM(gpu.memoriaVRAM());
        gpuExistente.setTipo(gpu.tipo());
        gpuExistente.setArquitetura(gpu.arquitetura());
    }

    @Override
    @Transactional
    public void deleteGpu(long id) {
        gpuRepository.deleteById(id);
    }

    @Override
    public GpuResponseDTO findById(long id) {
        Gpu gpu = gpuRepository.findById(id);
        return GpuResponseDTO.valueOf(gpu);
    }

    @Override
    public List<GpuResponseDTO> findByName(String name) {
        return gpuRepository.findByName(name).stream()
                .map(GpuResponseDTO::valueOf)
                .toList();
    }

    @Override
    public List<GpuResponseDTO> findAll() {
        return gpuRepository.findAll().stream()
            .map(GpuResponseDTO::valueOf)
            .toList();
    }

    @Override
    public List<GpuResponseDTO> findByManufacturer(long idManufacturer) {
        return gpuRepository.findByManufacturer(idManufacturer)
                .stream().map(e -> GpuResponseDTO.valueOf(e)).toList();
    }
}