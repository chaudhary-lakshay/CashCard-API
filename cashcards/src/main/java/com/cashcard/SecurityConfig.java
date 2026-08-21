package com.cashcard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(request -> request
                .requestMatchers("/", "/index.html", "/static/**")
                .permitAll()
                .requestMatchers("/cashcards/**")
                .hasRole("CARD-OWNER")
                .anyRequest()
                .authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Profile("!dev")
    UserDetailsService testOnlyUsers(
            PasswordEncoder passwordEncoder,
            @Value("${cashcard.users.sarah.username}") String sarahUsername,
            @Value("${cashcard.users.sarah.password}") String sarahPassword,
            @Value("${cashcard.users.hank.username}") String hankUsername,
            @Value("${cashcard.users.hank.password}") String hankPassword,
            @Value("${cashcard.users.kumar.username}") String kumarUsername,
            @Value("${cashcard.users.kumar.password}") String kumarPassword) {

        UserDetails sarah = User.builder()
                .username(sarahUsername)
                .password(passwordEncoder.encode(sarahPassword))
                .roles("CARD-OWNER")
                .build();

        UserDetails hank = User.builder()
                .username(hankUsername)
                .password(passwordEncoder.encode(hankPassword))
                .roles("NON-OWNER")
                .build();

        UserDetails kumar = User.builder()
                .username(kumarUsername)
                .password(passwordEncoder.encode(kumarPassword))
                .roles("CARD-OWNER")
                .build();

        return new InMemoryUserDetailsManager(
                sarah,
                hank,
                kumar
        );
    }
}