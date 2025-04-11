package dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import model.TypeGpu;

public record GpuDTO(
    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty(message = "Nome não pode ser vazio")
    String nome,
    Integer memoriaVRAM,
    TypeGpu tipo,
    String arquitetura,
    long idFabricante
) {}
