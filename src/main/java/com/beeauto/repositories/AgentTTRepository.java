package com.beeauto.repositories;

import com.beeauto.entities.responsableTT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgentTTRepository extends JpaRepository<responsableTT, Long> {

    @Query("SELECT a FROM responsableTT a " +
            "WHERE a.email = ?1")
    responsableTT findByEmail(String email);
}
