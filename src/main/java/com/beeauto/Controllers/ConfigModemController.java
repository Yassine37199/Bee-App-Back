package com.beeauto.Controllers;


import com.beeauto.entities.Abonnement;
import com.beeauto.entities.Ticket;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.AbonnementRepository;
import com.beeauto.repositories.ConfigModemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.beeauto.entities.ConfigModem;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/configmodem")
public class ConfigModemController {
    private final ConfigModemRepository configModemRepo;
    private final AbonnementRepository abonnementRepository;

    @Autowired
    public ConfigModemController(ConfigModemRepository configModemRepo, AbonnementRepository abonnementRepository) {
        this.configModemRepo = configModemRepo;
        this.abonnementRepository = abonnementRepository;
    }

    @GetMapping("/list")
    public List <ConfigModem> listconfigmodem()
    {
        return (List<ConfigModem>) configModemRepo.findAll();
    }

    @PostMapping("/add/{idAbonnement}")
    public ConfigModem addConfigModem(@Valid @RequestBody ConfigModem configModem,
                                      @PathVariable("idAbonnement") long idAbonnement){
        Abonnement abonnement = abonnementRepository.findById(idAbonnement)
                .orElseThrow(() -> new ResourceNotFoundException("Abonnement By id " + idAbonnement + " does not exist"));
        configModem.setAbonnement(abonnement);
        return configModemRepo.save(configModem);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConfigModem> UpdateTicket(@PathVariable("id") Long id ,
                                               @RequestBody ConfigModem configModem) {
        configModem.setIdConfig(id);
        configModemRepo.save(configModem);
        return new ResponseEntity<>(configModem , HttpStatus.OK);
    }
}
