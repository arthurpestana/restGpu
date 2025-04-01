package repository;

import model.Gpu;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GpuRepository implements PanacheRepository<Gpu> {

    public List<Gpu> findByName(String name) {
        return find("SELECT g FROM Gpu g WHERE g.nome LIKE ?1", "%" + name + "%").firstResult();
    }

    public List<Gpu> findByManufacturer(long idManufacturer) {
        return find("SELECT m FROM Manufacturer m WHERE m.manufacturer.id = ?1", idManufacturer).list();
    }
}