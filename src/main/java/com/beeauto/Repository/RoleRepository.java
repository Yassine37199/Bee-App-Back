package com.beeauto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beeauto.Entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
