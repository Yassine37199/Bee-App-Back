package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;


import com.beeauto.entities.Role;
import com.beeauto.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.beeauto.entities.Client;
import com.beeauto.exceptions.ResourceNotFoundException;
import com.beeauto.repositories.ClientRepository;


@CrossOrigin(origins = "*")
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

	@GetMapping("/cin/{cin}")
	public ResponseEntity<Client> getClientByCIN(@PathVariable("cin") int cin){
		Client client =  this.clientRepository.findByCin(cin);
		return new ResponseEntity<>(client , HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public ResponseEntity<Client> getOneClient(@PathVariable("id") Long id){
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client By Id " + id + " does not exist"));
		return new ResponseEntity<>(client , HttpStatus.OK);
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
		}).orElseThrow(() -> new ResourceNotFoundException("ClientID "+id+" not found"));
		}

}
