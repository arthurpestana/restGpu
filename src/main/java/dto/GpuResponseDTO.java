package dto;
import model.Manufacturer;
import model.TypeGpu;
import model.Gpu;

public record GpuResponseDTO(
    Long id,
    String nome,
    String fabricante,
    Integer memoriaVRAM,
    TypeGpu tipo,
    String arquitetura,
    Manufacturer manufacturer
) {

    public static GpuResponseDTO valueOf(Gpu gpu) {
        if (gpu == null)
            return null;
        return new GpuResponseDTO(
            gpu.getId(),
            gpu.getNome(),
            gpu.getFabricante(),
            gpu.getMemoriaVRAM(),
            gpu.getTipo(),
            gpu.getArquitetura(),
            gpu.getManufacturer()
        );
    }
}
