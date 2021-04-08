package com.beeauto.repositories;

import com.beeauto.entities.Commentaire;
import org.springframework.data.repository.CrudRepository;


public interface CommentRepository extends CrudRepository<Commentaire , Long> {
}
