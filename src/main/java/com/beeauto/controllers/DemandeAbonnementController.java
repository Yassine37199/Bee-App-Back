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
import com.beeauto.repositories.ClientRepository;
import com.beeauto.repositories.DemandeAbonnementRepository;

@RestController
@RequestMapping("/demandeAbonnement")
public class DemandeAbonnementController {

	
	private final DemandeAbonnementRepository demandeRepo;
	private final ClientRepository clientRepo;
	
	@Autowired
	public DemandeAbonnementController (DemandeAbonnementRepository demandeRepo,ClientRepository clientRepo) {
		
		this.demandeRepo=demandeRepo;
		this.clientRepo=clientRepo;
		
	}
	
	
	@GetMapping("/list")
	public List<DemandeAbonnement> listDemandes(){
		
		return (List<DemandeAbonnement>)demandeRepo.findAll();
		
	}
	
	
	@PostMapping("/add/{clientId}")
	public DemandeAbonnement addDemande(@PathVariable (value ="clientId")Long clientId, @Valid @RequestBody DemandeAbonnement demande) {
		
		return clientRepo.findById(clientId).map(client ->
		{ 
			// demande.setClient(client);
			return demandeRepo.save(demande);
			}).orElseThrow(() -> new ResourceNotFoundException("clientId "+ clientId + " not found"));

		
		
	}
	
	
	
	@PutMapping("/update/{clientId}/{idDemandeAbonnement}")
	public DemandeAbonnement updateClient(@PathVariable(value="clientId") Long clientId, @PathVariable (value="idDemandeAbonnement") Long demandeId, @Valid @RequestBody DemandeAbonnement demandeRequest) {
		
		if(!clientRepo.existsById(clientId)) {
			throw new ResourceNotFoundException("clientId "+clientId +" not found");
		}
		return demandeRepo.findById(demandeId).map(demande -> {
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
		}).orElseThrow(() -> new ResourceNotFoundException("DemandeID "+demandeId+" not found"));
		}
	
}
