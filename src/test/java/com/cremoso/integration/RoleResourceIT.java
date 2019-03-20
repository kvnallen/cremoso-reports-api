package com.cremoso.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cremoso.CremosoReportsApiApplication;
import com.cremoso.model.Role;
import com.cremoso.repository.RoleRepository;
import com.cremoso.resources.RoleResource;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoleResourceIT {

	@Autowired
	MockMvc mockMvc;

	
	@Autowired
	RoleRepository roleRepository;

	@Test
	@WithMockUser(username = "kevin", password = "kevin", roles = "USER")
	public void get_shouldGetAllRoles() throws Exception {
		roleRepository.saveAndFlush(new Role());
		roleRepository.saveAndFlush(new Role());

		mockMvc.perform(get("")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$", Matchers.hasSize(2)));
	}
}
