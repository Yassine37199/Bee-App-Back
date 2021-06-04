package com.beeauto.repositories;

import com.beeauto.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beeauto.entities.Agence;

@Repository
public interface AgenceRepository extends CrudRepository<Agence, Long> {

    @Query("SELECT a FROM Agence a " +
            "WHERE a.intitule = ?1")
    Agence findByIntitule(String intitule);

}
