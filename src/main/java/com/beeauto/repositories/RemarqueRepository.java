package com.beeauto.repositories;

import com.beeauto.Entities.Remarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RemarqueRepository extends JpaRepository<Remarque , Long> {
}
