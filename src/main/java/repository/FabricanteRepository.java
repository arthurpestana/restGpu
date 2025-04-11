package repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Fabricante;

import java.util.List;

@ApplicationScoped
public class FabricanteRepository implements PanacheRepository<Fabricante> {
    public List<Fabricante> findByNome(String nome) {
        return find("SELECT m FROM Fabricante m WHERE m.nome LIKE ?1 ", "%" + nome + "%").list();
    }
}
