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
import com.beeauto.Exception.ResourceNotFoundException;
import com.beeauto.repositories.RoleRepository;
import com.beeauto.repositories.UserRepository;

@RestController
@RequestMapping({"/roles"})

public class RoleController {
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;
	@Autowired
	public RoleController(RoleRepository roleRepository, UserRepository userRepository) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
	}
@GetMapping("/list")
public List<Role> getAllRole(){
	return (List<Role>) roleRepository.findAll();
}

@PostMapping("/add")
public Role createRole(@PathVariable (value = "userId") Long userId, @Valid @RequestBody Role role)
{
	
		return roleRepository.save(role);
	
}



@PutMapping("/update/{roleId}")
public Role updateRole(@PathVariable (value = "userId") Long userId,
		               @PathVariable (value = "roleId") Long roleId,
		               @Valid @RequestBody Role roleRequest) {
	
	return roleRepository.findById(roleId).map(role -> {
    role.setId(roleRequest.getId());
	role.setNomrole(roleRequest.getNomrole());
	return roleRepository.save(role);
	}).orElseThrow(() -> new
			ResourceNotFoundException("RoleId" + roleId + "not found"));
}


}

