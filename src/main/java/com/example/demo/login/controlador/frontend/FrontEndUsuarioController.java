package com.example.demo.login.controlador.frontend;

import com.example.demo.login.models.Usuario;
import com.example.demo.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FrontEndUsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @DeleteMapping("/usuario/delete/front/{id}")
    public String deleteUsuario(@PathVariable String id){
        usuarioService.delete(id);
        return "redirect:/welcome";
    }

    @GetMapping("/usuario/add")
    public String getAddUsuario(Model model){

        model.addAttribute("newUsuario",new Usuario());

        return "add-user";
    }


}
