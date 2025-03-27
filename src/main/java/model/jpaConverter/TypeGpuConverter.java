package model.jpaConverter;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import model.TypeGpu;

@Converter(autoApply = true)
public class TypeGpuConverter implements AttributeConverter<TypeGpu, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TypeGpu typeGpu) {
        return (typeGpu == null) ? null : typeGpu.getId();
    }

    @Override
    public TypeGpu convertToEntityAttribute(Integer id) {
        return TypeGpu.valueOf(id);
    }
}

