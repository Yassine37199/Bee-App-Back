package com.beeauto.controllers;

import com.beeauto.entities.Commentaire;
import com.beeauto.entities.Ticket;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.CommentRepository;
import com.beeauto.repositories.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
public class CommentController {

    private final CommentRepository commentRepository;
    private final TicketRepository ticketRepository;

    public CommentController(CommentRepository commentRepository, TicketRepository ticketRepository) {
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
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

    @PostMapping("/add/{ticketId}")
    public ResponseEntity<Commentaire> addComment(@PathVariable("ticketId") Long id,
                                                  @RequestBody Commentaire comment) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket By id " + id + " does not exist"));
        comment.setTicket(ticket);
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

}
