package dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
    @NotNull(message = "Não pode ser nulo")
    String username,

    @Size(min = 8, message = "A senha deve possuir no mínimo 8 caracteres.")
    @NotNull(message = "Não pode ser nulo")
    String password,

    @NotNull(message = "Não pode ser nulo")
    String email,

    @Size(max = 15, message = "O número de telefone deve ter no máximo 15 caracteres.")
    String telefone
) {}
