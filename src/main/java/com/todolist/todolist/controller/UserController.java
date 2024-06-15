package com.todolist.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolist.entity.UserEntity;
import com.todolist.todolist.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(Integer id) {
        UserEntity user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public void add(@RequestBody UserEntity userEntity) {
        userService.addUser(userEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity userEntity, @PathVariable long id) {
        UserEntity user = userService.updateUser(userEntity, id);
        return ResponseEntity.ok(user);
    }

}
