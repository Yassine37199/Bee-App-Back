package com.beeauto.repositories;

import com.beeauto.entities.point_vente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends CrudRepository<point_vente, Long> {

    @Query("SELECT a FROM point_vente a " +
            "WHERE a.intitule = ?1")
    point_vente findByIntitule(String intitule);

}
