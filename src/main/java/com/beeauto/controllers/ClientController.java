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
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.ClientRepository;



@RestController
@RequestMapping("/client")
public class ClientController {
	

	
	private final ClientRepository clientRepository;

	
	@Autowired
	public ClientController (ClientRepository clientRepository) {
		this.clientRepository=clientRepository;
	}
	
	
	
	@GetMapping("/list")
	public List<Client> listClients() {
		return (List<Client>)clientRepository.findAll() ;
	}
	
	
	
		
	@PostMapping("/add")
	public Client addClient(@Valid @RequestBody Client client ) {
	
		return clientRepository.save(client);
			
	}
	
	
	
	@PutMapping("/update/{id}")
	public Client updateClient(@PathVariable("id") long id, @Valid @RequestBody Client clientRequest) {
		return clientRepository.findById(id).map(client -> {
			client.setName(clientRequest.getName());
			client.setCin(clientRequest.getCin());
			client.setEmail(clientRequest.getEmail());
			client.setVille(clientRequest.getVille());
			client.setGouvernorat(clientRequest.getGouvernorat());
			client.setAdresse(clientRequest.getAdresse());
			client.setCodePostal(clientRequest.getCodePostal());
			client.setDateNaissance(clientRequest.getDateNaissance());
			client.setTelephone(clientRequest.getTelephone());
			client.setDateCreation(clientRequest.getDateCreation());
			return clientRepository.save(client);
		}).orElseThrow(() -> new ResourceNotFoundException("ClientID"+id+"not found"));
		}

}
