package com.beeauto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.beeauto.entities.DemandeAbonnement;

public interface DemandeAbonnementRepository extends JpaRepository<DemandeAbonnement, Long> {

}
