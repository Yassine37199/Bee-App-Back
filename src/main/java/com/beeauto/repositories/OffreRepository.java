package com.beeauto.repositories;

import com.beeauto.entities.Agence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.beeauto.entities.Offre;

public interface OffreRepository extends CrudRepository <Offre, Long>{

    @Query("SELECT o FROM Offre o " +
            "WHERE o.labelle = ?1")
    Offre findByLabelle(String labelle);

}


