package com.ahmed.pays.entities;

import jakarta.persistence.*;

@Entity
public class Plat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idPlat; // Identifier for the Plat
    private String nomPlat; // Name of the Plat
    private Double prixPlat; // Price of the Plat

    @ManyToOne // Indicating many Plat can belong to one Pays
    @JoinColumn(name = "id_pays") // Foreign key column in Plat table
    private Pays pays; // Reference to the Pays entity

    public Plat() {
        super();
    }

    public Plat(String nomPlat, Double prixPlat, Pays pays) { // Updated constructor to include Pays
        this.nomPlat = nomPlat;
        this.prixPlat = prixPlat;
        this.pays = pays;
    }

    // Getters and Setters
    public Long getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(Long idPlat) {
        this.idPlat = idPlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public Double getPrixPlat() {
        return prixPlat;
    }

    public void setPrixPlat(Double prixPlat) {
        this.prixPlat = prixPlat;
    }

    public Pays getPays() { // Getter for Pays
        return pays;
    }

    public void setPays(Pays pays) { // Setter for Pays
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Plat [idPlat=" + idPlat + ", nomPlat=" + nomPlat + ", prixPlat=" + prixPlat + ", pays=" + pays + "]";
    }
}
