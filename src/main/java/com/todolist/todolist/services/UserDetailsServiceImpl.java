package com.todolist.todolist.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todolist.todolist.entity.UserEntity;
import com.todolist.todolist.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userEntity.getRol().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRolName().name())));
        userEntity.getRol().stream().flatMap(role -> role.getPermissions().stream()).forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getName().name())));
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEnabled(),userEntity.getAccountNonExpired(),
                userEntity.getCredentialsNonExpired(), userEntity.getAccountNonLocked(), authorities);
    }
    
}
