package com.todolist.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.todolist.todolist.entity.RolEntity;
import com.todolist.todolist.repository.RolRepository;
import java.util.List;
import java.util.ArrayList;

@Service
public class RolServices {
    @Autowired
    private RolRepository rolRepository;

    public RolServices(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    public List<RolEntity> getAll() {
        List<RolEntity> rols = new ArrayList<>();
        rolRepository.findAll().forEach(rols::add);
        return rols;
    }
    public void add(RolEntity rol) {
        rolRepository.save(rol);
    }
    public void delete(long id) {
        rolRepository.deleteById(id);
    }
    public RolEntity update(RolEntity rol, long id) {
        RolEntity existRol = rolRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
        existRol.setRolName(rol.getRolName());
        return rolRepository.save(existRol);
    }
    public RolEntity getById(long id) {
        return rolRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }
    public RolEntity getByRolName(String rolName) {
        return rolRepository.findByRolName(rolName).orElseThrow(()-> new RuntimeException("not found"));
    }

}
