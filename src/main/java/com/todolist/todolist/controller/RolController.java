package com.todolist.todolist.controller;

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

import com.todolist.todolist.entity.RolEntity;
import com.todolist.todolist.services.RolServices;
import java.util.List;
@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolServices rolServices;

    @GetMapping("/all_roles")
    public List<RolEntity> getAllRols() {
        return (List<RolEntity>) rolServices.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<RolEntity> getRolById(@PathVariable Long id) {
        RolEntity rol = rolServices.getById(id);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{rolName}")
    public ResponseEntity<RolEntity> getRolByName(@PathVariable String rolName) {
        RolEntity rol = rolServices.getByRolName(rolName);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public void createRol(@RequestBody RolEntity rol) {
        rolServices.add(rol);

    }
    @PutMapping("/{id}")
    public void updateRol(@PathVariable Long id, @RequestBody RolEntity rol) {
        rolServices.update(rol, id);
    }
    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable Long id) {
        rolServices.delete(id);
    }

}
