package com.beeauto.repositories;

import com.beeauto.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket , Long> {
}
