package dto;
import model.Fabricante;
import model.TypeGpu;
import model.Gpu;

public record GpuResponseDTO(
    Long id,
    String nome,
    Integer memoriaVRAM,
    TypeGpu tipo,
    String arquitetura,
    Fabricante fabricante
) {

    public static GpuResponseDTO valueOf(Gpu gpu) {
        if (gpu == null)
            return null;
        return new GpuResponseDTO(
            gpu.getId(),
            gpu.getNome(),
            gpu.getMemoriaVRAM(),
            gpu.getTipo(),
            gpu.getArquitetura(),
            gpu.getFabricante()
        );
    }
}
