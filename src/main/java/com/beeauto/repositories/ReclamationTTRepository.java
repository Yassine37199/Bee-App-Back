package com.beeauto.repositories;

import com.beeauto.entities.Remarque;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.beeauto.entities.ReclamationTT;

import java.util.List;

public interface ReclamationTTRepository extends CrudRepository<ReclamationTT, Long> {

    @Query("SELECT rec FROM  ReclamationTT rec " +
            "WHERE rec.abonnement.idAbonnement = ?1")
    List<ReclamationTT> getReclamationTTByAbonnement(long idAbonnement);

}
