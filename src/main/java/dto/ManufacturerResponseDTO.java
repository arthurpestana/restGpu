package dto;

import model.Manufacturer;

public record ManufacturerResponseDTO(
        long id,
        String nome,
        String country
) {
    public static ManufacturerResponseDTO valueOf(Manufacturer manufacturer) {
        if (manufacturer == null) return null;
        return new ManufacturerResponseDTO(manufacturer.getId(), manufacturer.getName(), manufacturer.getCountry());
    }
}
