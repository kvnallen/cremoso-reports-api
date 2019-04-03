package com.cremoso.integration;

import com.cremoso.model.Tag;
import com.cremoso.repository.TagRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class TagResourceIT extends IntegrationTest {

    @Autowired
    TagRepository repository;

    @Test
    @WithMockUser()
    public void getAll_shouldReturnAllTags() throws Exception {
        repository.saveAndFlush(new Tag());
        repository.saveAndFlush(new Tag());


        requestGet("/tags")
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andDo(print());
    }
}
