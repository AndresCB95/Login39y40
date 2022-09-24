package com.example.demo.login.security;

import com.example.demo.login.service.MyUserDetailService;
import com.example.demo.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    SuccesGoogle succesGoogle;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/usuario/delete/**").hasAnyRole("ADMIN")
                .antMatchers("/menu").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .antMatchers("/login*").permitAll()
                .and()


                .formLogin()
                .loginPage("/login")
                .usernameParameter("nombreUsuario")
                .passwordParameter("password")
                .defaultSuccessUrl("/welcome")

                .and()

                .oauth2Login()
                .loginPage("/login")
                .successHandler(succesGoogle)

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }


}
