package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;

import com.beeauto.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.beeauto.entities.Agence;
import com.beeauto.repositories.AgenceRepository;
import com.beeauto.Exception.ResourceNotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/agence"})
public class AgenceController {
	@Autowired
	private AgenceRepository agenceRepository;


	@GetMapping("/list")
	public List<Agence>getAllAgence(){
		return (List<Agence>) agenceRepository.findAll();
	}

	@GetMapping("/intitule/{intitule}")
	public ResponseEntity<Agence> getAgenceByIntitule(@PathVariable("intitule") String intitule){
		Agence agence =  this.agenceRepository.findByIntitule(intitule);
		return new ResponseEntity<>(agence , HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Agence> getOneAgence(@PathVariable("id") Long id){
		Agence agence = agenceRepository.findById(id)
				.orElseThrow(() -> new com.beeauto.exceptions.ResourceNotFoundException("Agence By Id " + id + " does not exist"));
		return new ResponseEntity<>(agence , HttpStatus.OK);
	}

	@PostMapping("/add")
	public Agence createAgence(@Valid@RequestBody Agence agence) {
		return agenceRepository.save(agence);
	}

	@PutMapping("/update/{agenceId}")
	public Agence updateAgence (@PathVariable (value = "agenceId") Long
										agenceId, @Valid @RequestBody Agence agenceRequest) {

		return agenceRepository.findById(agenceId).map(agence -> {
			agence.setType(agenceRequest.getType());
			agence.setCode(agenceRequest.getCode());
			agence.setIntitule(agenceRequest.getIntitule());
			agence.setContact(agenceRequest.getContact());
			agence.setTel(agenceRequest.getTel());
			agence.setAdresse(agenceRequest.getAdresse());
			agence.setAgence_mere(agenceRequest.getAgence_mere());
			agence.setRegion(agenceRequest.getRegion());
			agence.setEtat(agenceRequest.getEtat());
			agence.setDetails(agenceRequest.getDetails());
			return agenceRepository.save(agence);
		}).orElseThrow(() -> new ResourceNotFoundException("agenceId" + agenceId + "notfound"));
	}
	
	

}
