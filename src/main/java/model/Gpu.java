package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Gpu extends DefaultEntity {

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private int memoriaVRAM;

    @Enumerated(EnumType.STRING)
    private TypeGpu tipo;

    @Column(length = 50, nullable = false)
    private String arquitetura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getMemoriaVRAM() {
        return memoriaVRAM;
    }

    public void setMemoriaVRAM(int memoriaVRAM) {
        this.memoriaVRAM = memoriaVRAM;
    }

    public TypeGpu getTipo() {
        return tipo;
    }

    public void setTipo(TypeGpu tipo) {
        this.tipo = tipo;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }
}
