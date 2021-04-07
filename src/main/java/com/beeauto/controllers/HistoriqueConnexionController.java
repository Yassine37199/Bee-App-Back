package com.beeauto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.beeauto.entities.HistoriqueConnexion;
import com.beeauto.repositories.HistoriqueConnexionRepository;


@RestController
@RequestMapping("/historiqueConnexion")

public class HistoriqueConnexionController {

			
			private final HistoriqueConnexionRepository histconnexionRepo;
			
			
			@Autowired
			public HistoriqueConnexionController (HistoriqueConnexionRepository histconnexionRepo)
			
			{
				this.histconnexionRepo=histconnexionRepo;
				
			}
			
			@GetMapping("/list")
			public List <HistoriqueConnexion> listhistconnexion()
			{
				
			return (List<HistoriqueConnexion>) histconnexionRepo.findAll();
				
			}}