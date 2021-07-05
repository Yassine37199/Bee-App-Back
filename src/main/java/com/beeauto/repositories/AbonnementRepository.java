package com.beeauto.repositories;

import com.beeauto.entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement , Long> {

    @Query("SELECT ab FROM Abonnement ab " +
            "WHERE ab.demandeAbonnement.idDemandeAbonnement = ?1")
    Abonnement findByDemandeId(long idDemandeAbonnement);

    @Query("SELECT ab FROM Abonnement ab " +
            "WHERE ab.demandeAbonnement.client.cin = ?1")
    List<Abonnement> findByCIN(int cin);

    @Query("SELECT ab FROM Abonnement ab " +
            "WHERE ab.refTT = ?1")
    List<Abonnement> findByRefTT(String reftt);

    @Query("SELECT ab FROM Abonnement ab " +
            "WHERE ab.demandeAbonnement.telADSL = ?1")
    List<Abonnement> findByTelFixe(int telADSL);


}
