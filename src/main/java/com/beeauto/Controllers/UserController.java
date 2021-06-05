package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;

import com.beeauto.entities.DemandeAbonnement;
import com.beeauto.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.beeauto.entities.Role;
import com.beeauto.entities.User;
import com.beeauto.repositories.RoleRepository;
import com.beeauto.repositories.UserRepository;
import com.beeauto.Exception.ResourceNotFoundException;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/user"})
public class UserController {
	@Autowired
	private UserRepository userRepository;
	private RoleRepository roleRepository;

	public UserController(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@GetMapping("/list")
	public List<User> getAllUser (){
		return (List<User>) userRepository.findAll();
	}

	@GetMapping("/{idUser}")
	public ResponseEntity<User> getOneUser(@PathVariable("idUser") Long idUser){
		User user = userRepository.findById(idUser)
				.orElseThrow(() -> new com.beeauto.exceptions.ResourceNotFoundException("User By Id " + idUser + " does not exist"));
		return new ResponseEntity<>(user , HttpStatus.OK);
	}

	@GetMapping("/get/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
		User user =  this.userRepository.findByEmail(email);
		return new ResponseEntity<User>(user , HttpStatus.OK);
	}

	@GetMapping("/get/N2")
	public List<User> getUserN2(){
		return (List<User>)this.userRepository.findByRole("agent support technique N2");

	}
	
	@PostMapping("/add/{roleId}")
	public User createUser(@PathVariable (value = "roleId") Long roleId , @Valid @RequestBody User user) {
		return roleRepository.findById(roleId).map(role -> {
			user.setRole(role);
			return userRepository.save(user);
		}).orElseThrow(() -> new ResourceNotFoundException("roleId" + roleId + "not found"));
		
	}
	
	@PutMapping("update/{userId}/{roleId}")
	public User updateUser(@PathVariable(value = "userId") Long userId,
			               @PathVariable(value = "roleId") Long roleId,
			@Valid @RequestBody User userRequest ) {
		return 
				userRepository.findById(userId).map(user -> {
					Role role = roleRepository.findById(roleId)
							.orElseThrow(() -> new ResourceNotFoundException("errreeeur"));
					user.setNom(userRequest.getNom());
					user.setPrenom(userRequest.getPrenom());
					user.setPassword(userRequest.getPassword());
					user.setTel(userRequest.getTel());
					user.setActive(userRequest.getActive());
					user.setRole(role);
					return userRepository.save(user);
					}).orElseThrow(() -> new
							ResourceNotFoundException("UserId" + userId + "not found"));
		
	}
}
	


