package com.beeauto.repositories;

import com.beeauto.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket , Long> {
}
