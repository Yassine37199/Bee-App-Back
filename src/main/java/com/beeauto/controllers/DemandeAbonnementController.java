package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;

import com.beeauto.entities.*;
import com.beeauto.repositories.AgenceRepository;
import com.beeauto.repositories.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.ClientRepository;
import com.beeauto.repositories.DemandeAbonnementRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/demandeAbonnement")
public class DemandeAbonnementController {


	private final DemandeAbonnementRepository demandeRepo;
	private final ClientRepository clientRepo;
	private final OffreRepository offreRepository;
	private final AgenceRepository agenceRepository;

	@Autowired
	public DemandeAbonnementController(DemandeAbonnementRepository demandeRepo,
									   ClientRepository clientRepo,
									   OffreRepository offreRepository,
									   AgenceRepository agenceRepository) {

		this.demandeRepo=demandeRepo;
		this.clientRepo=clientRepo;
		this.offreRepository = offreRepository;
		this.agenceRepository = agenceRepository;
	}


	@GetMapping("/list")
	public List<DemandeAbonnement> listDemandes(){

		return (List<DemandeAbonnement>)demandeRepo.findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<DemandeAbonnement> getOneDemande(@PathVariable("id") Long id){
		DemandeAbonnement demande = demandeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Demande By Id " + id + " does not exist"));
		return new ResponseEntity<>(demande , HttpStatus.OK);
	}

	@GetMapping("/get/backoffice/{agent}")
	public ResponseEntity<List<DemandeAbonnement>> getDemandeByBackOffice(@PathVariable("agent") String agent ){
		List<DemandeAbonnement> demandes = demandeRepo.getDemandeByAgentBackOffice(agent);
		return new ResponseEntity<>(demandes , HttpStatus.OK);
	}

	@GetMapping("/get/repartiton")
	public ResponseEntity<List<DemandeAbonnement>> getDemandeRepartition(){
		List<DemandeAbonnement> demandes = demandeRepo.getDemandeRepartition();
		return new ResponseEntity<>(demandes , HttpStatus.OK);
	}


	@PostMapping("/add/{idClient}/{idOffre}/{idAgence}")
	public DemandeAbonnement addDemande( @Valid @RequestBody DemandeAbonnement demande,
										 @PathVariable("idClient") Long idClient,
										 @PathVariable("idOffre") Long idOffre,
										 @PathVariable("idAgence") Long idAgence) {
		Client client = clientRepo.findById(idClient)
				.orElseThrow(() -> new ResourceNotFoundException("Client By id " + idClient + " does not exist"));
		Offre offre = offreRepository.findById(idOffre)
				.orElseThrow(() -> new ResourceNotFoundException("Offre By id " + idOffre + " does not exist"));
		Agence agence = agenceRepository.findById(idAgence)
				.orElseThrow(() -> new ResourceNotFoundException("Agence By id " + idAgence + " does not exist"));
		demande.setClient(client);
		demande.setOffre(offre);
		demande.setAgence(agence);
		return demandeRepo.save(demande);
	}



	@PutMapping("/update/{idDemandeAbonnement}/{idClient}/{idOffre}/{idAgence}")
	public DemandeAbonnement updateClient(@PathVariable (value="idDemandeAbonnement") Long demandeId,
										  @PathVariable("idClient") Long idClient,
										  @PathVariable("idOffre") Long idOffre,
										  @PathVariable("idAgence") Long idAgence,
										  @Valid @RequestBody DemandeAbonnement demandeRequest) {


		Client client = clientRepo.findById(idClient)
				.orElseThrow(() -> new ResourceNotFoundException("Client By id " + idClient + " does not exist"));
		Offre offre = offreRepository.findById(idOffre)
				.orElseThrow(() -> new ResourceNotFoundException("Offre By id " + idOffre + " does not exist"));
		Agence agence = agenceRepository.findById(idAgence)
				.orElseThrow(() -> new ResourceNotFoundException("Agence By id " + idAgence + " does not exist"));
		demandeRequest.setClient(client);
		demandeRequest.setOffre(offre);
		demandeRequest.setAgence(agence);
		demandeRequest.setIdDemandeAbonnement(demandeId);
		return demandeRepo.save(demandeRequest);
	}
	
}
