package com.beeauto.repositories;

import com.beeauto.entities.Remarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RemarqueRepository extends JpaRepository<Remarque , Long> {

    @Query("SELECT r FROM  Remarque r " +
    "WHERE r.demandeAbonnement.idDemandeAbonnement = ?1")
    List<Remarque> getRemarqueByDemande(long id_demande);


    @Query("SELECT r FROM  Remarque r " +
            "WHERE r.abonnement.idAbonnement = ?1")
    List<Remarque> getRemarqueByAbonnement(long idAbonnement);
}
