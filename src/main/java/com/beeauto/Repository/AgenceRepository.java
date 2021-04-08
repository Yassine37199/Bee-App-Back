package com.beeauto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beeauto.Entities.Agence;

@Repository
public interface AgenceRepository extends CrudRepository<Agence, Long> {

}
