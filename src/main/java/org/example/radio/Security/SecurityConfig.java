package org.example.radio.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Deshabilitar CSRF para API
        http
                .csrf((csrf) -> csrf.disable()) // Nueva forma de deshabilitar CSRF
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/users/create", "/api/users/delete", "/api/users/update").permitAll() // Permitir sin autenticación
                        .anyRequest().authenticated() // Requiere autenticación para otras rutas
                )
                .httpBasic(Customizer.withDefaults()); // Configurar autenticación básica, la forma actual de hacerlo

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}