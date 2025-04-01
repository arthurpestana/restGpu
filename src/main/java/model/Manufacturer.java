package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Manufacturer extends DefaultEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
