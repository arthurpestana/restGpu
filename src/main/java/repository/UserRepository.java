package repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    public List<User> findByUsername(String username) {
        return find("SELECT u FROM User u WHERE u.username LIKE ?1", "%" + username + "%").list();
    }

    public User findByEmail(String email) {
        return find("SELECT u FROM User u WHERE u.email LIKE ?1", "%" + email + "%" ).firstResult();
    }

    public User findByTelefone(String telefone) {
        return find("SELECT u FROM User u WHERE u.telefone LIKE ?1", "%" + telefone + "%").firstResult();
    }
    
}
