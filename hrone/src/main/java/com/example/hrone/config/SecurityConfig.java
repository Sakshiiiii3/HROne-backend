 package com.example.hrone.config;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.core.userdetails.UserDetailsService;

 @Configuration
 @EnableWebSecurity
 public class SecurityConfig extends WebSecurityConfigurerAdapter {

     @Autowired
     private UserDetailsService userDetailsService;

     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          Configure AuthenticationManager to use UserDetailsService and PasswordEncoder
         auth.userDetailsService(userDetailsService)
             .passwordEncoder(passwordEncoder());
     }

     @Override
     protected void configure(HttpSecurity http) throws Exception {
         http
             .csrf().disable()  Disable CSRF for stateless APIs, enable if needed
             .authorizeRequests()
                 .antMatchers("/api/auth/**").permitAll()  Allow public access to authentication endpoints
                 .anyRequest().authenticated()  All other requests require authentication
             .and()
             .formLogin()  Enable form-based login
                 .loginPage("/login")
                 .permitAll()
             .and()
             .logout()  Enable logout
                 .permitAll()
             .and()
             .exceptionHandling()  Handle exceptions
                 .accessDeniedPage("/403");  Custom access denied page
     }
 }
