package repository;

import model.Gpu;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GpuRepository implements PanacheRepository<Gpu> {

    public List<Gpu> findByNome(String nome) {
        return find("SELECT g FROM Gpu g WHERE g.nome LIKE ?1", "%" + nome + "%").firstResult();
    }

    public List<Gpu> findByFabricante(long idFabricante) {
        return find("SELECT m FROM Fabricante m WHERE m.fabricante.id = ?1", idFabricante).list();
    }
}