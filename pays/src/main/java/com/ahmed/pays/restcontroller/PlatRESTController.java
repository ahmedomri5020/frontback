package com.ahmed.pays.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.pays.entities.Plat;
import com.ahmed.pays.service.PlatService;

@RestController
@RequestMapping("/api/plats") // Updated the base request mapping for clarity
@CrossOrigin
public class PlatRESTController {

    @Autowired
    private PlatService platService; // Make private for better encapsulation

    @RequestMapping(method = RequestMethod.GET)
    public List<Plat> getAllPlats() {
        return platService.getAllPlats();
    }     

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Plat getPlatById(@PathVariable("id") Long id) {    
        return platService.getPlat(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Plat> createPlat(@RequestBody Plat plat) {
        Plat createdPlat = platService.savePlat(plat);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlat);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Plat updatePlat(@RequestBody Plat plat) {
        return platService.updatePlat(plat);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePlat(@PathVariable("id") Long id) {
        platService.deletePlatById(id);
    }
    
    @RequestMapping(value = "/platsPays/{idPays}", method = RequestMethod.GET)
    public List<Plat> getPlatsByPaysId(@PathVariable("idPays") Long idPays) {
        return platService.findByPaysId(idPays);
    }
}
