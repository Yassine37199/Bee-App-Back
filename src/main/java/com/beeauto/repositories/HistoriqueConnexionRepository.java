package com.beeauto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.beeauto.entities.HistoriqueConnexion;

@Repository
public interface HistoriqueConnexionRepository extends JpaRepository<HistoriqueConnexion, Long> {

}
