package com.example.demo.login.controlador.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {


    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

}
