package com.beeauto.Controllers;

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

import com.beeauto.Entities.User;
import com.beeauto.Exception.ResourceNotFoundException;
import com.beeauto.Repository.UserRepository;



@RestController
@RequestMapping({"/user"})
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/list")
	public List<User> getAllUser (){
		return (List<User>) userRepository.findAll();
	}
	
	@PostMapping("/add")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable Long userId, @Valid @RequestBody User userRequest) {
		return 
				userRepository.findById(userId).map(user -> {
					user.setNom(userRequest.getNom());
					user.setPrenom(userRequest.getPrenom());
					user.setPassword(userRequest.getPassword());
					user.setTel(userRequest.getTel());
					user.setId_role(userRequest.getId_role());
					user.setActive(userRequest.getActive());
					return userRepository.save(user);
					}).orElseThrow(() -> new
							ResourceNotFoundException("UserId" + userId + "not found"));
		
	}
}
	


