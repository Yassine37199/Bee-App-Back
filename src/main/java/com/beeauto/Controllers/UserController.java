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

import com.beeauto.entities.Role;
import com.beeauto.entities.User;
import com.beeauto.repositories.RoleRepository;
import com.beeauto.repositories.UserRepository;
import com.beeauto.Exception.ResourceNotFoundException;



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
					user.setId_role(userRequest.getId_role());
					user.setActive(userRequest.getActive());
					user.setRole(role);
					return userRepository.save(user);
					}).orElseThrow(() -> new
							ResourceNotFoundException("UserId" + userId + "not found"));
		
	}
}
	


