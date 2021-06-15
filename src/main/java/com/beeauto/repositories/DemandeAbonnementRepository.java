package com.beeauto.repositories;

import com.beeauto.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.beeauto.entities.DemandeAbonnement;

import java.util.List;

public interface DemandeAbonnementRepository extends JpaRepository<DemandeAbonnement, Long> {

    @Query("SELECT d FROM DemandeAbonnement d " +
            "WHERE d.agentBackOffice = ?1")
    List<DemandeAbonnement> getDemandeByAgentBackOffice(String AgentBackOffice);

}
