package dto;
import model.TypeGpu;

public record GpuDTO(
    String nome,
    String fabricante,
    Integer memoriaVRAM,
    TypeGpu tipo,
    String arquitetura,
    long idManufacturer
) {}
