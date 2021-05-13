package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;

import com.beeauto.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.beeauto.entities.Offre;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.OffreRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/offre")
public class OffreController {
	
private final OffreRepository offreRepository;

	
	@Autowired
	public OffreController (OffreRepository offreRepository) {
		this.offreRepository=offreRepository;
	}
	

	@GetMapping("/list")
	public List<Offre> listOffres() {
		return (List<Offre>)offreRepository.findAll() ;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Offre> getOneOffre(@PathVariable("id") Long id){
		Offre offre = offreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Offre By Id " + id + " does not exist"));
		return new ResponseEntity<>(offre , HttpStatus.OK);
	}
	

	@PostMapping("/add")
	public Offre addOffre(@Valid @RequestBody Offre offre ) {
		return offreRepository.save(offre);
	}
	

	@PutMapping("/update/{id}")
	public Offre updateOffre(@PathVariable("id") long id, @Valid @RequestBody Offre offreRequest) {
		return offreRepository.findById(id).map(offre -> {
			offre.setlabelle(offreRequest.getlabelle());
			offre.setDebit(offreRequest.getDebit());
			return offreRepository.save(offre);
		}).orElseThrow(() -> new ResourceNotFoundException("OffreID "+id+" not found"));
		}
}
