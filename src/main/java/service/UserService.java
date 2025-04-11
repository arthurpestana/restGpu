package service;

import java.util.List;

import dto.UserDTO;
import dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO create(UserDTO user);
    void update(long id, UserDTO user);
    void delete(long id);
    UserResponseDTO findById(long id);
    List<UserResponseDTO> findAll();
    List<UserResponseDTO> findByUsername(String username);
    UserResponseDTO findByEmail(String email);
    UserResponseDTO findByTelefone(String telefone);
}
