package com.example.demo.login.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/usuario").hasRole("ADMIN")
                .antMatchers("/menu").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .antMatchers("/login*").permitAll()
                .and()
                .formLogin().loginPage("/login");
    }


}
