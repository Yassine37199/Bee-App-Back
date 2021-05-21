package com.beeauto.repositories;

import com.beeauto.entities.Commentaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CommentRepository extends JpaRepository<Commentaire , Long> {

        @Query("SELECT c FROM  Commentaire c " +
                "WHERE c.ticket.idTicket = ?1")
        List<Commentaire> getCommentByTicket(long idTicket);


}
