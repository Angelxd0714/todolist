package com.todolist.todolist.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@RestController
@RequestMapping
public class LoginController {
   @Autowired
   private AuthenticationManager authenticationManager;

   @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
      try {
         Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                     loginRequest.username(), loginRequest.password()));
         SecurityContextHolder.getContext().setAuthentication(authentication);
         return ResponseEntity.ok("ok");
      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
      }

   }

}
