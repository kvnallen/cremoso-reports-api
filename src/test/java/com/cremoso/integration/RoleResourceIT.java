package com.cremoso.integration;

import com.cremoso.model.Role;
import com.cremoso.repository.RoleRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class RoleResourceIT extends IntegrationTest {


	
	@Autowired
	RoleRepository roleRepository;

	@Test
	@WithMockUser(username = "kevin", password = "kevin", roles = "USER")
	public void get_shouldGetAllRoles() throws Exception {
		roleRepository.saveAndFlush(new Role());
		roleRepository.saveAndFlush(new Role());

		requestGet("/rules")
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$", Matchers.hasSize(2)));
	}
}
