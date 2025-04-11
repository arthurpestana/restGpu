package service;

import java.util.List;

import dto.UserDTO;
import dto.UserResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.User;
import repository.UserRepository;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    @Override
    public UserResponseDTO create(UserDTO user) {
        User novoUser = new User();
        novoUser.setUsername(user.username());
        novoUser.setEmail(user.email());
        novoUser.setTelefone(user.telefone());
        novoUser.setPassword(user.password());

        userRepository.persist(novoUser);
        return UserResponseDTO.valueOf(novoUser);
    }

    @Transactional
    @Override
    public void update(long id, UserDTO user) {
        User userExistente = userRepository.findById(id);

        userExistente.setUsername(user.username());
        userExistente.setEmail(user.email());
        userExistente.setTelefone(user.telefone());
        userExistente.setPassword(user.password());

        userRepository.persist(userExistente);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDTO findById(long id) {
        User user = userRepository.findById(id);
        return UserResponseDTO.valueOf(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserResponseDTO::valueOf)
                .toList();
    }

    @Override
    public List<UserResponseDTO> findByUsername(String username) {
        return userRepository.findByUsername(username).stream()
                .map(UserResponseDTO::valueOf)
                .toList();
    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return UserResponseDTO.valueOf(user);
    }

    @Override
    public UserResponseDTO findByTelefone(String telefone) {
        User user = userRepository.findByTelefone(telefone);
        return UserResponseDTO.valueOf(user);
    }
}
