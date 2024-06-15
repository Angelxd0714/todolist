package com.todolist.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import java.util.Set;
import com.todolist.todolist.entity.PermissionsEntity;
import com.todolist.todolist.entity.RolEntity;
import com.todolist.todolist.entity.UserEntity;
import com.todolist.todolist.models.PermissionEnum;
import com.todolist.todolist.models.RolesEnum;
import com.todolist.todolist.repository.PermissionRepository;
import com.todolist.todolist.repository.RolRepository;
import com.todolist.todolist.repository.UserRepository;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository,RolRepository rolRepository,PermissionRepository permissionRepository) {
		return args -> {
			PermissionsEntity post = PermissionsEntity.builder().name(PermissionEnum.POST).build();
			PermissionsEntity get = PermissionsEntity.builder().name(PermissionEnum.GET).build();
			PermissionsEntity put = PermissionsEntity.builder().name(PermissionEnum.PUT).build();
			PermissionsEntity delete = PermissionsEntity.builder().name(PermissionEnum.DELETE).build();
			permissionRepository.saveAll(Set.of(post, get, put, delete));
			RolEntity admin = RolEntity.builder().rolName(RolesEnum.ADMIN).permissions(Set.of(post,get,put,delete)).build();
			UserEntity userAdmin = UserEntity.builder().username("admin").password("1234").enabled(true).accountNonExpired(false).accountNonLocked(true).credentialsNonExpired(false).rol(Set.of(admin)).build();
			rolRepository.save(admin);
			userRepository.save(userAdmin);
		};
	}

}
