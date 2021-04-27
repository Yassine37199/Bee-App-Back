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

import com.beeauto.entities.Offre;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.OffreRepository;

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
