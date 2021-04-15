package com.beeauto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beeauto.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
