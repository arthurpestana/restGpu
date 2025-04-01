package repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Manufacturer;

import java.util.List;

@ApplicationScoped
public class ManufacturerRepository implements PanacheRepository<Manufacturer> {
    public List<Manufacturer> findByName(String name) {
        return find("SELECT m FROM Manufacturer m WHERE m.nome LIKE ?1 ", "%" + name + "%").list();
    }
}
