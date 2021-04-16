package com.beeauto.repositories;

import com.beeauto.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket , Long> {
}
