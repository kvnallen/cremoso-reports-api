package com.cremoso.usecases;

import com.cremoso.model.User;
import com.cremoso.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AuthServiceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    AuthService service;


    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_whenUserIsNull_throwsException() {
        service.loadUserByUsername("invalid_username");
    }

    @Test
    public void loadUserByUsername_whenUserIsValid_returnsUser() {
        String username = "kvnallen";
        User user = new User();
        user.setUsername(username);
        user.setPassword("lol");
        when(repository.findByUsername(username)).thenReturn(user);
        String result = service.loadUserByUsername(username).getUsername();
        assertEquals(username, result);
    }
}