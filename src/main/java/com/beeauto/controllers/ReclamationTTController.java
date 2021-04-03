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

import com.beeauto.entites.Client;
import com.beeauto.entites.ReclamationTT;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.ReclamationTTRepository;

@RestController
@RequestMapping("/reclamationTT")
public class ReclamationTTController {
	
	
	private final ReclamationTTRepository recTT;
	
	
	@Autowired
	public ReclamationTTController (ReclamationTTRepository recTT) {
		
		this.recTT=recTT;
		
	}
	
	
	
	@GetMapping("/list")
	public List<ReclamationTT> listReclamations(){
		
		return (List<ReclamationTT>)recTT.findAll();
		
	}
	
	
	
	@PostMapping("/add")
	public ReclamationTT addRecTT(@Valid @RequestBody ReclamationTT reclamation) {
		
		return recTT.save(reclamation);
		
		
	}
	
	
	
	@PutMapping("/update/{id}")
	public ReclamationTT updateRecTT(@PathVariable("id") long id, @Valid @RequestBody ReclamationTT recRequest) {
		return recTT.findById(id).map(rec -> {
			rec.setTelADSL(recRequest.getTelADSL());
			rec.setObjet(recRequest.getObjet());
			rec.setEtat(recRequest.getEtat());
			rec.setDateReclamation(recRequest.getDateReclamation());
			rec.setDateEtat(recRequest.getDateEtat());
			return recTT.save(rec);
		}).orElseThrow(() -> new ResourceNotFoundException("reclamationID "+id+" not found"));
		}

}
