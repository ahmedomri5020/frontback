package com.ahmed.pays.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ahmed.pays.entities.Pays;
import com.ahmed.pays.service.PaysService;

@RestController
@RequestMapping("/api/pays")
@CrossOrigin // Allows cross-origin requests (useful for frontend development)
public class PaysRESTController {

    @Autowired
    PaysService paysService; // Injecting PaysService to handle business logic

    // Endpoint to get all Pays
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllPays() {
        List<Pays> paysList = paysService.getAllPays();
        Map<String, Object> response = new HashMap<>();
        response.put("_embedded", Map.of("pays", paysList)); // Wrap the list in an _embedded object
        return ResponseEntity.ok(response); // Return 200 with the wrapped response
    }

    // Endpoint to get Pays by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pays> getPaysById(@PathVariable("id") Long id) {
        Pays pays = paysService.getPays(id);
        if (pays == null) {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
        return ResponseEntity.ok(pays); // Return 200 with the Pays object
    }

    // Endpoint to create a new Pays
    @RequestMapping(method = RequestMethod.POST)
    public Pays createPays(@RequestBody Pays pays) {
        return paysService.savePays(pays);
    }

    // Endpoint to update an existing Pays
    @RequestMapping(method = RequestMethod.PUT)
    public Pays updatePays(@RequestBody Pays pays) {
        return paysService.savePays(pays); // Assuming savePays can also handle updates
    }

    // Endpoint to delete Pays by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePays(@PathVariable("id") Long id) {
        paysService.deletePaysById(id);
    }

    // Endpoint to search Pays by name
    @RequestMapping(value = "/search/{nom}", method = RequestMethod.GET)
    public List<Pays> getPaysByNom(@PathVariable("nom") String nom) {
        return paysService.findPaysByNom(nom);
    }
}
