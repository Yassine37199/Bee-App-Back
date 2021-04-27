package com.beeauto.controllers;

import com.beeauto.entities.Commentaire;
import com.beeauto.entities.Ticket;
import com.beeauto.entities.User;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.CommentRepository;
import com.beeauto.repositories.TicketRepository;
import com.beeauto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
public class CommentController {

    private final CommentRepository commentRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Commentaire>> getComments() {
        List<Commentaire> comments = commentRepository.findAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Commentaire> getOneComment(@PathVariable("id") Long id) {
        Commentaire comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment By Id " + id + " does not exist"));
        return new ResponseEntity<>(comment, HttpStatus.OK);

    }

    @PostMapping("/add/{ticketId}/{idUser}")
    public ResponseEntity<Commentaire> addComment(@PathVariable("ticketId") Long ticketId,
                                                  @PathVariable("idUser") Long idUser,
                                                  @RequestBody Commentaire comment) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket By id " + ticketId + " does not exist"));
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User By id " + idUser + " does not exist"));
        comment.setTicket(ticket);
        comment.setUser(user);
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

}
