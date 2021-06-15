package com.beeauto.controllers;

import com.beeauto.entities.Abonnement;
import com.beeauto.entities.Role;
import com.beeauto.entities.Ticket;
import com.beeauto.entities.User;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.AbonnementRepository;
import com.beeauto.repositories.TicketRepository;
import com.beeauto.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final AbonnementRepository abonnementRepository;

    public TicketController(TicketRepository ticketRepository,
                            UserRepository userRepository,
                            AbonnementRepository abonnementRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.abonnementRepository = abonnementRepository;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets = ticketRepository.findAll();
        return new ResponseEntity<>(tickets , HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Ticket> getOneTicket(@PathVariable("id") long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket By Id " + id + " does not exist"));
        return new ResponseEntity<>(ticket , HttpStatus.OK);
    }

    @GetMapping("/get/abonnement/{idAbonnement}")
    public ResponseEntity<List<Ticket>> getTicketsByAbonnement(@PathVariable("idAbonnement") long id ){
        List<Ticket> tickets = ticketRepository.getTicketByAbonnement(id);
        return new ResponseEntity<>(tickets , HttpStatus.OK);
    }

    @GetMapping("/get/user/{idUser}")
    public ResponseEntity<List<Ticket>> getTicketByUser(@PathVariable("idUser") long id ){
        List<Ticket> tickets = ticketRepository.getTicketByUser(id);
        return new ResponseEntity<>(tickets , HttpStatus.OK);
    }

    @GetMapping("/get/N2/{agentN2}")
    public ResponseEntity<List<Ticket>> getTicketByN2(@PathVariable("agentN2") String agentN2 ){
        List<Ticket> tickets = ticketRepository.getTicketByUserN2(agentN2);
        return new ResponseEntity<>(tickets , HttpStatus.OK);
    }

    @PostMapping("/add/{idUser}/{idAbonnement}")
    public ResponseEntity<Ticket> addTicket(@PathVariable("idUser") long idUser ,
                                            @RequestBody Ticket ticket,
                                            @PathVariable("idAbonnement") long idAbonnement) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User By id " + idUser + " does not exist"));
        Abonnement abonnement = abonnementRepository.findById(idAbonnement)
                .orElseThrow(() -> new ResourceNotFoundException("Abonnement By id " + idAbonnement + " does not exist"));
        ticket.setUser(user);
        ticket.setAbonnement(abonnement);
        ticketRepository.save(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}/{idAbonnement}")
    public ResponseEntity<Ticket> UpdateTicket(@PathVariable("id") Long id ,
                                               @PathVariable("idAbonnement") Long idAbonnement,
                                               @RequestBody Ticket ticket) {
        Abonnement abonnement = abonnementRepository.findById(idAbonnement)
                .orElseThrow(() -> new com.beeauto.Exception.ResourceNotFoundException("errreeeur"));
        ticket.setIdTicket(id);
        ticket.setAbonnement(abonnement);
        ticketRepository.save(ticket);
        return new ResponseEntity<>(ticket , HttpStatus.OK);
    }

}
