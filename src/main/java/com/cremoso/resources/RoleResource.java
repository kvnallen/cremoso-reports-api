package com.cremoso.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cremoso.model.Role;
import com.cremoso.repository.RoleRepository;

@RestController
public class RoleResource {

	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping
	public List<Role> getAll(){
		return roleRepository.findAll(); 
	}
}
