package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;

import com.beeauto.entities.point_vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.beeauto.repositories.AgenceRepository;
import com.beeauto.Exception.ResourceNotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/agence"})
public class AgenceController {
	@Autowired
	private AgenceRepository agenceRepository;


	@GetMapping("/list")
	public List<point_vente>getAllAgence(){
		return (List<point_vente>) agenceRepository.findAll();
	}

	@GetMapping("/intitule/{intitule}")
	public ResponseEntity<point_vente> getAgenceByIntitule(@PathVariable("intitule") String intitule){
		point_vente pointvente =  this.agenceRepository.findByIntitule(intitule);
		return new ResponseEntity<>(pointvente, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<point_vente> getOneAgence(@PathVariable("id") Long id){
		point_vente pointvente = agenceRepository.findById(id)
				.orElseThrow(() -> new com.beeauto.exceptions.ResourceNotFoundException("point_vente By Id " + id + " does not exist"));
		return new ResponseEntity<>(pointvente, HttpStatus.OK);
	}

	@PostMapping("/add")
	public point_vente createAgence(@Valid@RequestBody point_vente pointvente) {
		return agenceRepository.save(pointvente);
	}

	@PutMapping("/update/{agenceId}")
	public point_vente updateAgence (@PathVariable (value = "agenceId") Long
										agenceId, @Valid @RequestBody point_vente pointventeRequest) {

		return agenceRepository.findById(agenceId).map(agence -> {
			agence.setType(pointventeRequest.getType());
			agence.setCode(pointventeRequest.getCode());
			agence.setIntitule(pointventeRequest.getIntitule());
			agence.setContact(pointventeRequest.getContact());
			agence.setTel(pointventeRequest.getTel());
			agence.setAdresse(pointventeRequest.getAdresse());
			agence.setAgence_mere(pointventeRequest.getAgence_mere());
			agence.setRegion(pointventeRequest.getRegion());
			agence.setEtat(pointventeRequest.getEtat());
			agence.setDetails(pointventeRequest.getDetails());
			agence.setActive(pointventeRequest.isActive());
			return agenceRepository.save(agence);
		}).orElseThrow(() -> new ResourceNotFoundException("agenceId" + agenceId + "notfound"));
	}
	
	

}
