package com.beeauto.controllers;


import com.beeauto.entities.Abonnement;
import com.beeauto.repositories.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abonnement")
public class AbonnementController {

    private final AbonnementRepository abonnementRepo;


    @Autowired
    public AbonnementController (AbonnementRepository abonnementRepo)

    {
        this.abonnementRepo=abonnementRepo;

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
