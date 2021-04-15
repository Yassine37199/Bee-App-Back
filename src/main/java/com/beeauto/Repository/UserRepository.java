package com.beeauto.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beeauto.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
