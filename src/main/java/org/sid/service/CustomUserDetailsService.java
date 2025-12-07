package org.sid.service;

import lombok.RequiredArgsConstructor;
import org.sid.domain.repository.UserRepository;
import org.sid.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found with username: "+username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(), user.get().getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.get().getRole())));
    }
}
