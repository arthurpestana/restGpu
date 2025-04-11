package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Fabricante extends DefaultEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String pais;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
