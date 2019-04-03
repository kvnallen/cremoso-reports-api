package com.cremoso;

import com.cremoso.model.User;
import com.cremoso.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sun.security.util.Password;

import javax.annotation.PostConstruct;

@Component

public class Startup {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @PostConstruct
    public void init(){
        val user = new User();
        if(repository.findByUsername("kvnallen") != null) return;
        user.setUsername("kvnallen");
        user.setPassword(encoder.encode("1234"));
        repository.save(user);
    }

}
