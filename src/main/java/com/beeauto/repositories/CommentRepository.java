package com.beeauto.repositories;

import com.beeauto.Entities.Commentaire;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Commentaire , Long> {}
