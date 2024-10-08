package com.ahmed.pays.service;

import java.util.List;

import com.ahmed.pays.entities.Plat;

public interface PlatService {
    
    Plat savePlat(Plat p);
    Plat updatePlat(Plat p);
    void deletePlat(Plat p);
    void deletePlatById(Long id);
    Plat getPlat(Long id);
    List<Plat> getAllPlats();
    
    List<Plat> findByNomPlat(String nom);
    List<Plat> findByNomPlatContains(String nom);
    List<Plat> findByNomPrix(String nom, Double prix);
    List<Plat> findByOrderByNomPlatAsc();
    List<Plat> trierPlatsNomsPrix();
    
    // Add this method to find plats by Pays ID
    List<Plat> findByPaysId(Long idPays);
}
