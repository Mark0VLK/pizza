package com.example.pizza.config;

import com.example.pizza.secure.filter.JwtAuthenticationFilter;
import com.example.pizza.secure.service.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.example.pizza.enums.secure.Permission.ADMIN_CREATE;
import static com.example.pizza.enums.secure.Permission.ADMIN_DELETE;
import static com.example.pizza.enums.secure.Permission.ADMIN_UPDATE;
import static com.example.pizza.enums.secure.Role.ADMIN;
import static com.example.pizza.enums.secure.Role.CUSTOMER;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutService logoutService;
    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors(cors -> cors.configurationSource(corsConfig.corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(new AntPathRequestMatcher("/api/v1/auth/**")).permitAll()

                        // CategoryController
                        .requestMatchers(GET, "/api/v1/category/**").hasAnyRole(ADMIN.name(), CUSTOMER.name())
                        .requestMatchers("/api/v1/category/**").hasRole(ADMIN.name())
                        .requestMatchers(POST, "/api/v1/category/**").hasAuthority(ADMIN_CREATE.name())
                        .requestMatchers(PUT, "/api/v1/category/**").hasAuthority(ADMIN_UPDATE.name())
                        .requestMatchers(DELETE, "/api/v1/category/**").hasAuthority(ADMIN_DELETE.name())

                        // DishController
                        .requestMatchers(GET, "/api/v1/dish/**").hasAnyRole(ADMIN.name(), CUSTOMER.name())
                        .requestMatchers("/api/v1/dish/**").hasRole(ADMIN.name())
                        .requestMatchers(POST, "/api/v1/dish/**").hasAuthority(ADMIN_CREATE.name())
                        .requestMatchers(PUT, "/api/v1/dish/**").hasAuthority(ADMIN_UPDATE.name())
                        .requestMatchers(DELETE, "/api/v1/dish/**").hasAuthority(ADMIN_DELETE.name())

                        // DrinkController
                        .requestMatchers(GET, "/api/v1/drink/**").hasAnyRole(ADMIN.name(), CUSTOMER.name())
                        .requestMatchers("/api/v1/drink/**").hasRole(ADMIN.name())
                        .requestMatchers(POST, "/api/v1/drink/**").hasAuthority(ADMIN_CREATE.name())
                        .requestMatchers(PUT, "/api/v1/drink/**").hasAuthority(ADMIN_UPDATE.name())
                        .requestMatchers(DELETE, "/api/v1/drink/**").hasAuthority(ADMIN_DELETE.name())

                        // InformationController
                        .requestMatchers(GET, "/api/v1/information/**").hasAnyRole(ADMIN.name(), CUSTOMER.name())
                        .requestMatchers("/api/v1/information/**").hasRole(ADMIN.name())
                        .requestMatchers(POST, "/api/v1/information/**").hasAuthority(ADMIN_CREATE.name())
                        .requestMatchers(PUT, "/api/v1/information/**").hasAuthority(ADMIN_UPDATE.name())
                        .requestMatchers(DELETE, "/api/v1/information/**").hasAuthority(ADMIN_DELETE.name())

                        // LocationController
                        .requestMatchers(GET, "/api/v1/location/**").hasAnyRole(ADMIN.name(), CUSTOMER.name())
                        .requestMatchers("/api/v1/location/**").hasRole(ADMIN.name())
                        .requestMatchers(POST, "/api/v1/location/**").hasAuthority(ADMIN_CREATE.name())
                        .requestMatchers(PUT, "/api/v1/location/**").hasAuthority(ADMIN_UPDATE.name())
                        .requestMatchers(DELETE, "/api/v1/location/**").hasAuthority(ADMIN_DELETE.name())

                        // OrderController
                        .requestMatchers("/api/v1/order/**").hasAnyRole(ADMIN.name(), CUSTOMER.name())

                        // PizzaController
                        .requestMatchers(GET, "/api/v1/pizza/**").hasAnyRole(ADMIN.name(), CUSTOMER.name())
                        .requestMatchers("/api/v1/pizza/**").hasRole(ADMIN.name())
                        .requestMatchers(POST, "/api/v1/pizza/**").hasAuthority(ADMIN_CREATE.name())
                        .requestMatchers(PUT, "/api/v1/pizza/**").hasAuthority(ADMIN_UPDATE.name())
                        .requestMatchers(DELETE, "/api/v1/pizza/**").hasAuthority(ADMIN_DELETE.name())

                        // UserController
                        .requestMatchers("/api/v1/user/**").hasRole(ADMIN.name())


                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .logoutUrl("/api/v1/auth/logout")
                        .addLogoutHandler(logoutService)
                        .logoutSuccessHandler((request, response, authentication) ->
                                SecurityContextHolder.clearContext())
                );

        return httpSecurity.build();
    }
}
