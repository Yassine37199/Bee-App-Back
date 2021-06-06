package com.beeauto.repositories;

import com.beeauto.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket , Long> {

    @Query("SELECT t FROM Ticket t " +
            "WHERE t.abonnement.idAbonnement = ?1")
    List<Ticket> getTicketByAbonnement(long idAbonnement);


    @Query("SELECT t FROM Ticket t " +
    "WHERE t.user.idUser = ?1")
    List<Ticket> getTicketByUser(long idUser);


    @Query("SELECT t FROM Ticket t " +
            "WHERE t.AgentN2 = ?1")
    List<Ticket> getTicketByUserN2(String AgentN2);
}


