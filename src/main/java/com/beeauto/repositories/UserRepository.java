package com.beeauto.repositories;


import com.beeauto.entities.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beeauto.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u " +
    "WHERE u.email = ?1")
    User findByEmail(String email);

    @Query("SELECT u FROM User u " +
            "WHERE u.role.nomrole = ?1")
    List<User> findByRole(String nomrole);



}
