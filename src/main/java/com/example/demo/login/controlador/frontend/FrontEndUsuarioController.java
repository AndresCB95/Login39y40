package com.example.demo.login.controlador.frontend;

import com.example.demo.login.models.Rol;
import com.example.demo.login.models.Usuario;
import com.example.demo.login.service.PerfilService;
import com.example.demo.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontEndUsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PerfilService perfilService;


    @DeleteMapping("/usuario/delete/front/{id}")
    public String deleteUsuario(@PathVariable String id){
        usuarioService.delete(id);
        return "redirect:/welcome";
    }

    @GetMapping("/usuario/add")
    public String getAddUsuario(Model model){

        model.addAttribute("newUsuario",new Usuario());
        model.addAttribute("perfiles",perfilService.getPefiles());
        model.addAttribute("roles", Rol.values());

        return "add-user";
    }

    @GetMapping("/usuario/update/front/{id}")
    public String getUsuario(Model model, @PathVariable String id){

        try {
            model.addAttribute("UpdateUsuario",usuarioService.getUsuario(id));
            model.addAttribute("perfiles",perfilService.getPefiles());
            model.addAttribute("roles", Rol.values());
            return "update-user";
        } catch (Exception e) {
           return "redirect:/error";
        }

    }

    @PatchMapping("/usuario/front/{id}")
    public String patchUsuario(@ModelAttribute("UpdateUsuario") Usuario usuario, @PathVariable String id){

        try {
            usuarioService.patchUsuario(usuario,id);
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

    @PostMapping("/usuario/front")
    public String postUsuario(@ModelAttribute("newUsuario") Usuario usuario){

        usuarioService.saveUsuario(usuario);

        return "redirect:/welcome";
    }


}
