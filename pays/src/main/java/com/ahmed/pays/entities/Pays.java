package com.ahmed.pays.entities;

import jakarta.persistence.*;

@Entity
public class Pays {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idPays; // Identifier for the Pays
    private String nomPays; // Name of the Pays
    private String descriptionPays; // Description of the Pays

    public Pays() {
        super();
    }

    public Pays(String nomPays, String descriptionPays) {
        this.nomPays = nomPays;
        this.descriptionPays = descriptionPays;
    }

    // Getters and Setters
    public Long getIdPays() {
        return idPays;
    }

    public void setIdPays(Long idPays) {
        this.idPays = idPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public String getDescriptionPays() {
        return descriptionPays;
    }

    public void setDescriptionPays(String descriptionPays) {
        this.descriptionPays = descriptionPays;
    }

    @Override
    public String toString() {
        return "Pays [idPays=" + idPays + ", nomPays=" + nomPays + ", descriptionPays=" + descriptionPays + "]";
    }
}
