package com.cremoso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cremoso.model.Role;
import com.cremoso.repository.RoleRepository;

@RequestMapping("roles")
@RestController
public class RoleResource {

	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping
	public List<Role> getAll(){
		roleRepository.saveAndFlush(new Role());
		return roleRepository.findAll(); 
	}
	
	@PostMapping("")
	public Role saveOrUpdate(Role role) {
		return roleRepository.save(role);
	}
}
