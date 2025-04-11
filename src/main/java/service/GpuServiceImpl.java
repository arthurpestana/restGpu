package service;

import dto.GpuDTO;
import dto.GpuResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Gpu;
import repository.GpuRepository;

import java.util.List;

import repository.FabricanteRepository;

@ApplicationScoped
public class GpuServiceImpl implements GpuService {

    @Inject
    GpuRepository gpuRepository;

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    @Transactional
    public GpuResponseDTO create(GpuDTO gpu) {
        Gpu novaGpu = new Gpu();
        novaGpu.setNome(gpu.nome());
        novaGpu.setMemoriaVRAM(gpu.memoriaVRAM());
        novaGpu.setTipo(gpu.tipo());
        novaGpu.setArquitetura(gpu.arquitetura());
        novaGpu.setFabricante(fabricanteRepository.findById(gpu.idFabricante()));

        gpuRepository.persist(novaGpu);

        return GpuResponseDTO.valueOf(novaGpu);
    }

    @Override
    @Transactional
    public void update(long id, GpuDTO gpu) {
        Gpu gpuExistente = gpuRepository.findById(id);

        gpuExistente.setNome(gpu.nome());
        gpuExistente.setFabricante(fabricanteRepository.findById(gpu.idFabricante()));
        gpuExistente.setMemoriaVRAM(gpu.memoriaVRAM());
        gpuExistente.setTipo(gpu.tipo());
        gpuExistente.setArquitetura(gpu.arquitetura());
    }

    @Override
    @Transactional
    public void delete(long id) {
        gpuRepository.deleteById(id);
    }

    @Override
    public GpuResponseDTO findById(long id) {
        Gpu gpu = gpuRepository.findById(id);
        return GpuResponseDTO.valueOf(gpu);
    }

    @Override
    public List<GpuResponseDTO> findByNome(String nome) {
        return gpuRepository.findByNome(nome).stream()
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
    public List<GpuResponseDTO> findByFabricante(long idFabricante) {
        return gpuRepository.findByFabricante(idFabricante)
                .stream().map(e -> GpuResponseDTO.valueOf(e)).toList();
    }
}