package com.beeauto.repositories;

import com.beeauto.entities.AgentTT;
import com.beeauto.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgentTTRepository extends JpaRepository<AgentTT, Long> {

    @Query("SELECT a FROM AgentTT a " +
            "WHERE a.email = ?1")
    AgentTT findByEmail(String email);
}
