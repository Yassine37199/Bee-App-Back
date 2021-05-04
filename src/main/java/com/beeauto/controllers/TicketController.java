package com.beeauto.controllers;

import com.beeauto.entities.Ticket;
import com.beeauto.entities.User;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.TicketRepository;
import com.beeauto.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public TicketController(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
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

    @PostMapping("/add/{idUser}")
    public ResponseEntity<Ticket> addTicket(@PathVariable("idUser") long idUser , @RequestBody Ticket ticket) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User By id " + idUser + " does not exist"));
        ticket.setUser(user);
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
