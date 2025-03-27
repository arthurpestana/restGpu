package model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeGpu {
    ENTRY_LEVEL(1, "Entrada"),
    MID_RANGE(2, "Intermediária"),
    HIGH_END(3, "Topo de Linha"),
    WORKSTATION(4, "Workstation"),
    AI_ACCELERATOR(5, "Acelerador de IA");

    private final int id;
    private final String nome;

    TypeGpu(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static TypeGpu valueOf(Integer id) {
        if (id == null)
            return null;
        for (TypeGpu type : TypeGpu.values()) {
            if (type.getId() == id)
                return type;
        }
        return null;
    }
}
