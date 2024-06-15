package com.todolist.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.todolist.todolist.services.UserDetailsServiceImpl;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> {
                    authorize
                            .requestMatchers(HttpMethod.GET, "/tasks/**")
                            .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "ROLE_GUEST")
                            .requestMatchers(HttpMethod.GET, "/tasks/{id}")
                            .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "ROLE_GUEST")
                            .requestMatchers(HttpMethod.POST, "/tasks/").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                            .requestMatchers(HttpMethod.PUT, "/tasks/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                            .requestMatchers(HttpMethod.DELETE, "/tasks/{id}")
                            .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                            .requestMatchers(HttpMethod.GET, "/users/**").hasAnyRole("ADMIN", "USER")
                            .requestMatchers(HttpMethod.GET, "/users").hasAnyAuthority("ADMIN", "USER")
                            .requestMatchers(HttpMethod.POST, "/users").hasAnyAuthority("ADMIN", "USER")
                            .requestMatchers(HttpMethod.PUT, "/users/**").hasAnyAuthority("ADMIN", "USER")
                            .requestMatchers(HttpMethod.DELETE, "/users/**").hasAnyAuthority("ADMIN", "USER")
                            .anyRequest().denyAll();
                })

                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailsServiceImpl) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsServiceImpl);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
