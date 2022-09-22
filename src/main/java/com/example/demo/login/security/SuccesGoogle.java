package com.example.demo.login.security;

import com.example.demo.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccesGoogle implements AuthenticationSuccessHandler {

    @Autowired
    UsuarioService usuarioService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
       DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal();

       String email = user.getEmail();

       System.out.println(user);
       System.out.println(email);

        try {
            usuarioService.getUsuario(email);
            response.sendRedirect("/welcome");
        } catch (Exception e) {
            //Logout en google
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }


    }
}
