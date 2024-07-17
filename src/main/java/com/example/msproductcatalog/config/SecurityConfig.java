
package com.example.msproductcatalog.config;

import com.example.msproductcatalog.service.auth.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


//Öz login pageinizi hazırlayırsız. Servis qalxanda
// həmin login page-ə yönləndiriləcək və login bu səhifədən gələn
// request üzərindən getməlidir. Uğurlu logində swaggerə
// və ya hansısa başqa bir səhifəyə yönləndirmə edə bilərsiz
@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                                req.requestMatchers(
                                                "/product/add",
                                                "/product/addPhoto",
                                                "/product/addPhoto",
                                                "product/delete/**",
                                                "/category/add",
                                                "/category/delete/**",
                                                "/category/edit/**").
                                        hasRole("SUPERUSER")
                                        .requestMatchers(
                                                "/basket/add",
                                                "/order").
                                        hasAnyRole("SUPERUSER", "USER")
                                        .requestMatchers("/register",
                                                "/login",
                                                "/product",
                                                "product/find/**",
                                                "/category",
                                                "/category/find/**"
                                        )
                                        .permitAll().
                                        requestMatchers(permitSwagger).permitAll()
//                ).formLogin(i->i.defaultSuccessUrl("/swagger-ui.html").permitAll())

                ).formLogin((form) -> form
                        .loginPage("/login").defaultSuccessUrl("/swagger-ui.html")
                        .permitAll())
                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .logoutSuccessHandler((request, response, authentication)
                                        -> SecurityContextHolder.clearContext())
                ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
        ;
        return http.build();
    }
//
//    @Value("${spring.security.user.name}")
//    String username;
//    @Value("${spring.security.user.password}")
//    String password;
//    @Value("${spring.security.user.roles}")
//    String role;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    public static String[] permitSwagger = {
            "swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/webjars/**"
    };


}

