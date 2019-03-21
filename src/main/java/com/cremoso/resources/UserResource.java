package com.cremoso.resources;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cremoso.model.User;

import lombok.val;

@RestController
@RequestMapping("users")
public class UserResource {

	@GetMapping("/current")
	public User	current () {
		val user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
}
