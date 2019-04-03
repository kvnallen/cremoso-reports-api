package com.cremoso.usecases;

import com.cremoso.model.Permission;
import com.cremoso.model.User;
import com.cremoso.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    private PasswordEncoder encoder;
    private UserRepository repository;

    public AuthService(
            PasswordEncoder encoder,
            UserRepository repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if(user == null) throw new UsernameNotFoundException("Invalid username");
        return toUserDetails(user);
    }

    private UserDetails toUserDetails(User user){
        UserBuilder builder;
        builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        builder.password(user.getPassword());
        builder.accountExpired(false);
        builder.disabled(false);
        builder.accountLocked(false);
        builder.credentialsExpired(false);
        builder.authorities(new ArrayList<>());
//        builder.authorities(toAuthorities(user.getPermissions()));

        return builder.build();
    }

    private List<GrantedAuthority> toAuthorities(Set<Permission> permissions){
        return
                permissions.stream()
                .map(x -> new SimpleGrantedAuthority(x.getRole().getTitle()))
            .collect(Collectors.toList());
    }
}
