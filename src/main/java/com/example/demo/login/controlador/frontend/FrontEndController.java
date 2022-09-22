package com.example.demo.login.controlador.frontend;

import com.example.demo.login.models.Usuario;
import com.example.demo.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontEndController {

    @Autowired
    UsuarioService usuarioService;


    @GetMapping("/")
    public String getIndex(){
        return "index";
    }


    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formularioUsuario",new Usuario());
        return "login";
    }


    //public String postLogin(Model model){
        //Usuario usuario = (Usuario) model.getAttribute("formularioUsuario");
    @PostMapping("/login")
    public String postLogin(@ModelAttribute("formularioUsuario") Usuario usuario){
        System.out.println(usuario);
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String getWelcome(Model model){
        model.addAttribute("usuarios",usuarioService.getUsuarios());
        return "welcome";
    }


}
