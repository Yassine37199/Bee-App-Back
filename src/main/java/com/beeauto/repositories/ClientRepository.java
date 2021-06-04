package com.beeauto.repositories;

import com.beeauto.entities.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.beeauto.entities.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

    @Query("SELECT c FROM Client c " +
            "WHERE c.cin = ?1")
    Client findByCin(int cin);
}

