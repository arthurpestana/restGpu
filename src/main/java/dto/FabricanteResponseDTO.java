package dto;

import model.Fabricante;

public record FabricanteResponseDTO(
        long id,
        String nome,
        String pais
) {
    public static FabricanteResponseDTO valueOf(Fabricante fabricante) {
        if (fabricante == null) return null;
        return new FabricanteResponseDTO(fabricante.getId(), fabricante.getNome(), fabricante.getPais());
    }
}
