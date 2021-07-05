package com.beeauto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.beeauto.entities.Role;
import com.beeauto.entities.User;
import com.beeauto.Exception.ResourceNotFoundException;
import com.beeauto.repositories.RoleRepository;
import com.beeauto.repositories.UserRepository;

@CrossOrigin(origins = "*")
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

@GetMapping("/{roleId}")
public Role getRole(@PathVariable (value = "roleId") Long roleId){
		return this.roleRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Role By Id " + roleId + " does not exist"));
	}

	@GetMapping("/nom/{nomrole}")
	public ResponseEntity<Role> getUserByEmail(@PathVariable("nomrole") String nomrole){
		Role role =  this.roleRepository.findByNom(nomrole);
		return new ResponseEntity<Role>(role , HttpStatus.OK);
	}

@PostMapping("/add")
public Role createRole( @Valid @RequestBody Role role)
{
		return roleRepository.save(role);
}



@PutMapping("/update/{roleId}")
public Role updateRole(
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

