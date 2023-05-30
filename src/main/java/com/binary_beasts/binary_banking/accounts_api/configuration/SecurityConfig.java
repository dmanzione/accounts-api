//package com.binary_beasts.binary_banking.accounts_api.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author user
// */
//@Configuration
//@EnableWebSecurity
//public
//class SecurityConfig {
//
//    /**
//     * @return BCrypt encoder
//     */
//    @Bean
//    PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//
//        List<UserDetails> usersList = new ArrayList<>();
//
//
//        User user = new User("user", passwordEncoder.encode("user"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_EMPLOYEE"), new SimpleGrantedAuthority("ROLE_CUSTOMER")));
//
//
//        usersList.add(user);
//        return new InMemoryUserDetailsManager(usersList);
//    }
//
//    @Bean
//    public org.springframework.security.web.DefaultSecurityFilterChain filterChain(HttpSecurity http)
//            throws
//            Exception {
//        return http.authorizeHttpRequests().anyRequest().permitAll().and().httpBasic().and().build();
//
//
//    }
//
//
//}
