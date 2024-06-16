package com.todolist.todolist.entity;

import com.todolist.todolist.models.PermissionEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permissions")
public class PermissionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",unique = true, updatable = true)
    @Enumerated(EnumType.STRING)
    private PermissionEnum name;
   



}
