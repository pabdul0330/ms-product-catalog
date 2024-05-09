package com.example.msproductcatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig  {



    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/basket").hasAuthority("USER")

                        .anyRequest().authenticated()
                ).formLogin(f->f.defaultSuccessUrl("/basket"));
        return http.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers("/authors","/books")
                                .permitAll()
                                .requestMatchers("/teachers").hasAnyRole("ADMIN")

                ).formLogin(f->f.defaultSuccessUrl("/books"))
//                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .logoutSuccessHandler((request, response, authentication)
                                        -> SecurityContextHolder.clearContext())
                );
        return http.build();
    }


    @Bean
    public UserDetailsService users() {
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("Peyman")
                        .password("salam")
                        .roles("USER","ADMIN")
                        .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
