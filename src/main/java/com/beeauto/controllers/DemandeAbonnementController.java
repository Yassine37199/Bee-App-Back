package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beeauto.entities.DemandeAbonnement;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.DemandeAbonnementRepository;

@RestController
@RequestMapping("/demandeAbonnement")
public class DemandeAbonnementController {

	
	private final DemandeAbonnementRepository demandeRepo;
	
	
	@Autowired
	public DemandeAbonnementController (DemandeAbonnementRepository demandeRepo) {
		
		this.demandeRepo=demandeRepo;
		
	}
	
	
	@GetMapping("/list")
	public List<DemandeAbonnement> listDemandes(){
		
		return (List<DemandeAbonnement>)demandeRepo.findAll();
		
	}
	
	
	@PostMapping("/add")
	public DemandeAbonnement addDemande(@Valid @RequestBody DemandeAbonnement demande) {
		
		return demandeRepo.save(demande);
		
	}
	
	
	@PutMapping("/update/{id}")
	public DemandeAbonnement updateClient(@PathVariable("id") long id, @Valid @RequestBody DemandeAbonnement demandeRequest) {
		return demandeRepo.findById(id).map(demande -> {
			demande.setOffre(demandeRequest.getOffre());
			demande.setDebit(demandeRequest.getDebit());
			demande.setFrequencePaiement(demandeRequest.getFrequencePaiement());
			demande.setAdresseInstallation(demandeRequest.getAdresseInstallation());
			demande.setVille(demandeRequest.getVille());
			demande.setGouvernorat(demandeRequest.getGouvernorat());
			demande.setDateCreation(demandeRequest.getDateCreation());
			demande.setAgenceCreation(demandeRequest.getAgenceCreation());
			demande.setEtat(demandeRequest.getEtat());
			demande.setTelADSL(demandeRequest.getTelADSL());
			demande.setTypeDemande(demandeRequest.getTypeDemande());
			return demandeRepo.save(demande);
		}).orElseThrow(() -> new ResourceNotFoundException("DemandeID "+id+" not found"));
		}
	
}
