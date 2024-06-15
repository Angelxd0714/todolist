package com.todolist.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todolist.todolist.entity.UserEntity;
import com.todolist.todolist.repository.UserRepository;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUser(){
        return (List<UserEntity>) userRepository.findAll();
    }
    public UserEntity getUser(long id){
        return userRepository.findById(id).orElseThrow(()-> new  UsernameNotFoundException("UserNotFOund"));
    }
    public UserEntity addUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }
    public UserEntity updateUser(UserEntity userEntity, long id){
        UserEntity existUser = userRepository.findById(id).orElseThrow(()-> new  UsernameNotFoundException("UserNotFOund"));
        existUser.setUsername(userEntity.getUsername());
        existUser.setPassword(userEntity.getPassword());
        existUser.setEnabled(userEntity.getEnabled());
        existUser.setAccountNonExpired(userEntity.getAccountNonExpired());
        existUser.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        existUser.setAccountNonLocked(userEntity.getAccountNonLocked());
        existUser.setRol(userEntity.getRol());
        return userRepository.save(existUser);
    }
    public void deleteUser(long id){
        userRepository.deleteById(id);
        
    }
    
}
