package com.beeauto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beeauto.entities.Agence;

@Repository
public interface AgenceRepository extends CrudRepository<Agence, Long> {

}
