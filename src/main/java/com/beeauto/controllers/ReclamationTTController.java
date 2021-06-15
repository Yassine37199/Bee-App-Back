package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;

import com.beeauto.entities.Abonnement;
import com.beeauto.entities.User;
import com.beeauto.repositories.AbonnementRepository;
import com.beeauto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.beeauto.entities.Client;
import com.beeauto.entities.ReclamationTT;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.ReclamationTTRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reclamationTT")
public class ReclamationTTController {


	private final ReclamationTTRepository recTT;
	private final UserRepository userRepository;
	private final AbonnementRepository abonnementRepository;


	@Autowired
	public ReclamationTTController(ReclamationTTRepository recTT, UserRepository userRepository, AbonnementRepository abonnementRepository) {

		this.recTT=recTT;
		this.userRepository = userRepository;

		this.abonnementRepository = abonnementRepository;
	}



	@GetMapping("/list")
	public List<ReclamationTT> listReclamations(){

		return (List<ReclamationTT>)recTT.findAll();

	}

	@GetMapping("/{idReclamation}")
	public ReclamationTT listReclamations(@PathVariable("idReclamation") long idReclamation){

		return recTT.findById(idReclamation)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamation By Id " + idReclamation + " does not exist"));

	}

	@GetMapping("/list/abonnement/{idAbonnement}")
	public List<ReclamationTT> getReclamationTTByAbonnement(@PathVariable("idAbonnement") long idAbonnement){
		return (List<ReclamationTT>)recTT.getReclamationTTByAbonnement(idAbonnement);
	}



	@PostMapping("/add/{idUser}/{idAbonnement}")
	public ReclamationTT addRecTT(@Valid @RequestBody ReclamationTT reclamation ,
								  @PathVariable("idUser") long idUser ,
								  @PathVariable("idAbonnement") long idAbonnement) {
		User user = userRepository.findById(idUser)
				.orElseThrow(() -> new ResourceNotFoundException("User By id " + idUser + " does not exist"));
		Abonnement abonnement = abonnementRepository.findById(idAbonnement)
				.orElseThrow(() -> new ResourceNotFoundException("Abonnement By id " + idAbonnement + " does not exist"));
		reclamation.setUser(user);
		reclamation.setAbonnement(abonnement);
		return recTT.save(reclamation);
	}



	@PutMapping("/update/{id}/{idAbonnement}")
	public ReclamationTT updateRecTT(@PathVariable("id") long id,
									 @Valid @RequestBody ReclamationTT recRequest,
									 @PathVariable("idAbonnement") long idAbonnement) {
		Abonnement abonnement = abonnementRepository.findById(idAbonnement)
				.orElseThrow(() -> new ResourceNotFoundException("Abonnement By id " + idAbonnement + " does not exist"));
		return recTT.findById(id).map(rec -> {
			rec.setAbonnement(abonnement);
			rec.setTelADSL(recRequest.getTelADSL());
			rec.setObjet(recRequest.getObjet());
			rec.setEtat(recRequest.getEtat());
			rec.setDateReclamation(recRequest.getDateReclamation());
			rec.setDateEtat(recRequest.getDateEtat());
			return recTT.save(rec);
		}).orElseThrow(() -> new ResourceNotFoundException("reclamationID "+id+" not found"));
	}

}
