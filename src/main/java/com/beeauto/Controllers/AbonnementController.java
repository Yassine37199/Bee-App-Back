package com.beeauto.controllers;


import com.beeauto.entities.Abonnement;
import com.beeauto.entities.Client;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.AbonnementRepository;
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


    @Autowired
    public AbonnementController (AbonnementRepository abonnementRepo)

    {
        this.abonnementRepo=abonnementRepo;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Abonnement> getOneClient(@PathVariable("id") Long id){
        Abonnement abonnement = abonnementRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Abonnement By Id " + id + " does not exist"));
        return new ResponseEntity<>(abonnement , HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Abonnement> listAbonnement()
    {

        return (List<Abonnement>) abonnementRepo.findAll();

    }

    @PostMapping("/add")
    public Abonnement addAbonnement(
            @Valid
            @RequestBody Abonnement abonnement) {

        return abonnementRepo.save(abonnement);

    }
}
