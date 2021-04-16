package com.beeauto.repositories;

import org.springframework.data.repository.CrudRepository;

import com.beeauto.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{

}
