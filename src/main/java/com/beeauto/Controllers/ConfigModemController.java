package com.beeauto.Controllers;


import com.beeauto.repositories.ConfigModemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.beeauto.entities.ConfigModem;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/configmodem")
public class ConfigModemController {
    private final ConfigModemRepository configModemRepo;

    @Autowired
    public ConfigModemController(ConfigModemRepository configModemRepo) {
        this.configModemRepo = configModemRepo;
    }

    @GetMapping("/list")
    public List <ConfigModem> listconfigmodem()
    {
        return (List<ConfigModem>) configModemRepo.findAll();
    }

    @PostMapping("/add/{idAbonnement}")
    public ConfigModem addConfigModem(@Valid @RequestBody ConfigModem configModem,
                                      @PathVariable("idAbonnement") long idAbonnement){

        return configModemRepo.save(configModem);
    }
}
