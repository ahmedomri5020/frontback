package com.ahmed.pays.repo;

import com.ahmed.pays.entities.Pays;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RepositoryRestResource(path = "pays")
public interface PaysRepository extends JpaRepository<Pays, Long> {
    
    // Find Pays by exact name
    List<Pays> findByNomPays(String nom);

    // Find Pays by name containing the given substring (case-insensitive)
    List<Pays> findByNomPaysContainingIgnoreCase(String nom);

    @Query("select p from Pays p where p.descriptionPays like %:description%")
    List<Pays> findByDescription(@Param("description") String description);
    // Sort Pays by name in ascending order
    @Query("select p from Pays p order by p.nomPays ASC")
    List<Pays> trierPaysParNom();

    // Additional custom queries can be added here
}
