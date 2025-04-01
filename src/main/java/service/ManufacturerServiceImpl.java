package service;

import dto.ManufacturerDTO;
import dto.ManufacturerResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Manufacturer;
import repository.ManufacturerRepository;

import java.util.List;

@ApplicationScoped
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    ManufacturerRepository manufacturerRepository;

    @Override
    @Transactional
    public ManufacturerResponseDTO create(ManufacturerDTO dto) {
        Manufacturer novoManufacturer = new Manufacturer();
        novoManufacturer.setName(dto.name());
        novoManufacturer.setCountry(dto.country());

        manufacturerRepository.persist(novoManufacturer);
        return ManufacturerResponseDTO.valueOf(novoManufacturer);
    }

    @Override
    @Transactional
    public void update(long id, ManufacturerDTO dto) {
        Manufacturer edicaoManufacturer = manufacturerRepository.findById(id);

        edicaoManufacturer.setName(dto.name());
        edicaoManufacturer.setCountry(dto.country());
    }

    @Override
    @Transactional
    public void delete(long id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public ManufacturerResponseDTO findById(long id) {
        return ManufacturerResponseDTO.valueOf(manufacturerRepository.findById(id));
    }

    @Override
    public List<ManufacturerResponseDTO> findAll() {
        return manufacturerRepository.findAll().stream().map(e -> ManufacturerResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ManufacturerResponseDTO> findByNome(String nome) {
        return manufacturerRepository.findByName(nome).stream().map(e -> ManufacturerResponseDTO.valueOf(e)).toList();
    }
}
