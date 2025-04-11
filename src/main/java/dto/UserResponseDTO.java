package dto;

import model.User;

public record UserResponseDTO(
    Long id,
    String username,
    String email,
    String telefone
) {
    public static UserResponseDTO valueOf(User user) {
        if (user == null)
            return null;
        return new UserResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getTelefone()
        );
    }
}
