package com.beeauto.controllers;

import com.beeauto.entities.Commentaire;
import com.beeauto.entities.Ticket;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets = ticketRepository.findAll();
        return new ResponseEntity<>(tickets , HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Ticket> getOneTicket(@PathVariable("id") Long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket By Id " + id + " does not exist"));
        return new ResponseEntity<>(ticket , HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        ticketRepository.save(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ticket> UpdateTicket(@PathVariable("id") Long id ,
                                               @RequestBody Ticket ticket) {
        ticket.setIdTicket(id);
        ticketRepository.save(ticket);
        return new ResponseEntity<>(ticket , HttpStatus.OK);
    }
}
