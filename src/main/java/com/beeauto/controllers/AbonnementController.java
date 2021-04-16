package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.beeauto.entities.Abonnement;
import com.beeauto.repositories.AbonnementRepository;

	
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
		public List <Abonnement> listAbonnement()
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
