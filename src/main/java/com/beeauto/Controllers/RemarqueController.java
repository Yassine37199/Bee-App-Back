package com.beeauto.Controllers;

import com.beeauto.entities.*;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.AbonnementRepository;
import com.beeauto.repositories.DemandeAbonnementRepository;
import com.beeauto.repositories.RemarqueRepository;
import com.beeauto.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remarque/")
public class RemarqueController {

    private final RemarqueRepository remarqueRepository;
    private final UserRepository userRepository;
    private final AbonnementRepository abonnementRepository;
    private final DemandeAbonnementRepository demandeAbonnementRepository;




    public RemarqueController(RemarqueRepository remarqueRepository, UserRepository userRepository, AbonnementRepository abonnementRepository, DemandeAbonnementRepository demandeAbonnementRepository) {
        this.remarqueRepository = remarqueRepository;
        this.userRepository = userRepository;
        this.abonnementRepository = abonnementRepository;
        this.demandeAbonnementRepository = demandeAbonnementRepository;
    }

    @GetMapping("get/all")
    public ResponseEntity<List<Remarque>> getAllRemarques(){
        List<Remarque> remarques = remarqueRepository.findAll();
        return new ResponseEntity<>(remarques , HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Remarque> getOneRemarque(@PathVariable("id") Long id){
        Remarque remarque = remarqueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Remarque By Id " + id + " does not exist"));
        return new ResponseEntity<>(remarque , HttpStatus.OK);
    }

    @PostMapping("/add/{idAbonnement}/{idUser}")
    public ResponseEntity<Remarque> addRemarqueForAbonnement(@PathVariable("idAbonnement") Long idAbonnement,
                                                  @PathVariable("idUser") Long idUser,
                                                  @RequestBody Remarque remarque) {
        Abonnement abonnement = abonnementRepository.findById(idAbonnement)
                .orElseThrow(() -> new ResourceNotFoundException("Abonnement By id " + idAbonnement + " does not exist"));
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User By id " + idUser + " does not exist"));
        remarque.setAbonnement(abonnement);
        remarque.setUser(user);
        remarqueRepository.save(remarque);
        return new ResponseEntity<>(remarque, HttpStatus.CREATED);
    }

    @PostMapping("/add/{idDemandeAbonnement}/{idUser}")
    public ResponseEntity<Remarque> addRemarqueForDemande(@PathVariable("idDemandeAbonnement") Long idDemandeAbonnement,
                                                             @PathVariable("idUser") Long idUser,
                                                             @RequestBody Remarque remarque) {
        DemandeAbonnement demandeAbonnement = demandeAbonnementRepository.findById(idDemandeAbonnement)
                .orElseThrow(() -> new ResourceNotFoundException("Demande abonnement By id " + idDemandeAbonnement + " does not exist"));
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User By id " + idUser + " does not exist"));
        remarque.setDemandeAbonnement(demandeAbonnement);
        remarque.setUser(user);
        remarqueRepository.save(remarque);
        return new ResponseEntity<>(remarque, HttpStatus.CREATED);
    }
}
