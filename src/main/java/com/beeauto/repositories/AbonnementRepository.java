package com.beeauto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.beeauto.entities.Abonnement;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
	
	
}

