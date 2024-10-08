package com.ahmed.pays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.pays.entities.Plat;
import com.ahmed.pays.repo.PlatRepository;

@Service
public class PlatServiceImpl implements PlatService {

    @Autowired
    PlatRepository platRepository;

    @Override
    public Plat savePlat(Plat p) {
        return platRepository.save(p);
    }

    @Override
    public Plat updatePlat(Plat p) {
        return platRepository.save(p);
    }

    @Override
    public void deletePlat(Plat p) {
        platRepository.delete(p);
    }

    @Override
    public void deletePlatById(Long id) {
        platRepository.deleteById(id);
    }

    @Override
    public Plat getPlat(Long id) {
        return platRepository.findById(id).orElse(null);
    }

    @Override
    public List<Plat> getAllPlats() {
        return platRepository.findAll();
    }

    @Override
    public List<Plat> findByNomPlat(String nom) {
        return platRepository.findByNomPlat(nom);
    }

    @Override
    public List<Plat> findByNomPlatContains(String nom) {
        return platRepository.findByNomPlatContains(nom);
    }

    @Override
    public List<Plat> findByNomPrix(String nom, Double prix) {
        return platRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Plat> findByOrderByNomPlatAsc() {
        return platRepository.findByOrderByNomPlatAsc();
    }

    @Override
    public List<Plat> trierPlatsNomsPrix() {
        return platRepository.trierPlatsNomsPrix();
    }

    @Override
    public List<Plat> findByPaysId(Long idPays) {
        // Implement this method to find plats by Pays ID if needed
        return platRepository.findByPays_IdPays(idPays);
    }
}