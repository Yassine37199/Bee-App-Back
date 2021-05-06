package com.beeauto.Controllers;

import com.beeauto.entities.HistoriqueConnexion;
import com.beeauto.repositories.HistoriqueConnexionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historiqueConnexion")
public class HistoriqueConnexionController {

    private final HistoriqueConnexionRepository historiqueConnexionRepo;

    @Autowired
    public HistoriqueConnexionController(HistoriqueConnexionRepository historiqueConnexionRepo) {
        this.historiqueConnexionRepo = historiqueConnexionRepo;
    }

    @GetMapping("/list")
    public List<HistoriqueConnexion> listHisConnexion(){
        return (List<HistoriqueConnexion>) historiqueConnexionRepo.findAll();
    }
}
