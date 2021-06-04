package com.beeauto.controllers;


import com.beeauto.entities.Abonnement;
import com.beeauto.entities.Agence;
import com.beeauto.entities.Ticket;
import com.beeauto.entities.User;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.AbonnementRepository;
import com.beeauto.repositories.DemandeAbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/abonnement")
public class AbonnementController {

    private final AbonnementRepository abonnementRepo;
    private final DemandeAbonnementRepository demandeAbonnementRepository;


    @Autowired
    public AbonnementController(AbonnementRepository abonnementRepo, DemandeAbonnementRepository demandeAbonnementRepository)

    {
        this.abonnementRepo=abonnementRepo;

        this.demandeAbonnementRepository = demandeAbonnementRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abonnement> getOneClient(@PathVariable("id") Long id){
        Abonnement abonnement = abonnementRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Abonnement By Id " + id + " does not exist"));
        return new ResponseEntity<>(abonnement , HttpStatus.OK);
    }

    @GetMapping("/demande/{idDemandeAbonnement}")
    public ResponseEntity<Abonnement> getAgenceByIntitule(@PathVariable("idDemandeAbonnement") long idDemandeAbonnement){
        Abonnement abonnement =  this.abonnementRepo.findByDemandeId(idDemandeAbonnement);
        return new ResponseEntity<>(abonnement , HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Abonnement> listAbonnement()
    {

        return (List<Abonnement>) abonnementRepo.findAll();

    }

    @PostMapping("/add/{idDemandeAbonnement}")
    public Abonnement createAbonnement(@PathVariable (value = "idDemandeAbonnement") Long idDemandeAbonnement ,
                           @Valid @RequestBody Abonnement abonnement) {
        return demandeAbonnementRepository.findById(idDemandeAbonnement).map(demande -> {
            abonnement.setDemandeAbonnement(demande);
            return abonnementRepo.save(abonnement);
        }).orElseThrow(() -> new com.beeauto.Exception.ResourceNotFoundException("Demande" + idDemandeAbonnement + "not found"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Abonnement> UpdateTicket(@PathVariable("id") Long id ,
                                               @RequestBody Abonnement abonnement) {
        abonnement.setIdAbonnement(id);
        abonnementRepo.save(abonnement);
        return new ResponseEntity<>(abonnement , HttpStatus.OK);
    }

}
