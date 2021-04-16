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

import com.beeauto.entities.Agence;
import com.beeauto.repositories.AgenceRepository;
import com.beeauto.Exception.ResourceNotFoundException;

@RestController
@RequestMapping({"/agence"})
public class AgenceController {
	@Autowired
	private AgenceRepository agenceRepository;
	
		
	@GetMapping("/list")
	public List<Agence>getAllAgence(){
		return (List<Agence>) agenceRepository.findAll();
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
    		agence.setUtilisateur(agenceRequest.getUtilisateur());
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
