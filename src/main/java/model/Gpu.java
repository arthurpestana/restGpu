package model;

import jakarta.persistence.*;

@Entity
public class Gpu extends DefaultEntity {

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private int memoriaVRAM;

    @Enumerated(EnumType.STRING)
    private TypeGpu tipo;

    @Column(length = 50, nullable = false)
    private String arquitetura;

    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
