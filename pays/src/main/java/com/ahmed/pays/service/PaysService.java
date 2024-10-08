package com.ahmed.pays.service;

import java.util.List;

import com.ahmed.pays.entities.Pays;

public interface PaysService {
    Pays savePays(Pays pays);
    Pays updatePays(Pays pays);
    void deletePays(Pays pays);
    void deletePaysById(Long id);
    Pays getPays(Long id);
    List<Pays> getAllPays();
    List<Pays> findPaysByNom(String nom);
}
