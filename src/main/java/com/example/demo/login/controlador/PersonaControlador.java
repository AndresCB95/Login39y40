package com.example.demo.login.controlador;

import com.example.demo.login.models.Persona;
import com.example.demo.login.models.Usuario;
import com.example.demo.login.models.UsuarioResponse;
import com.example.demo.login.service.PersonaService;
import com.example.demo.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonaControlador {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> getPersonas(){
        return new ResponseEntity<List<Persona>>(
                personaService.getPersonas(),
                HttpStatus.OK
        );
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<Object> getPersona(@PathVariable Integer id){

        try {
            System.out.println("Metodo Url");
            Persona persona = personaService.getPersona(id);
            return new ResponseEntity<>(persona,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persona")
    public ResponseEntity<Object> getPersonas(@RequestParam Integer id){
        try {
            System.out.println("Metodo Url");
            Persona persona = personaService.getPersona(id);
            return new ResponseEntity<>(persona,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/persona")
    public ResponseEntity<UsuarioResponse> postUsuario(@RequestBody Persona persona){
        return new ResponseEntity<>(

                new UsuarioResponse("persona Creado Exitosamente",
                personaService.savePersona(persona))

                ,HttpStatus.OK);
    }

    @PutMapping("/persona")
    public ResponseEntity<UsuarioResponse> putUsuario(@RequestBody Persona persona){
        return new ResponseEntity<>(
        new UsuarioResponse("Usuario Actualizado Exitosamente", personaService.putPersona(persona))
        ,HttpStatus.OK);
    }

    @PatchMapping("/persona/{id}")
    public ResponseEntity<UsuarioResponse> patch(@RequestBody Persona persona, @PathVariable Integer id){
        try {
            return new ResponseEntity<>(
                    new UsuarioResponse("Actualizacion Exitosa", personaService.patchPersona(persona, id)),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new UsuarioResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<UsuarioResponse> delete(@PathVariable Integer id){
        return new ResponseEntity<>(

                new UsuarioResponse(personaService.delete(id), null),
                HttpStatus.OK
        );
    }


}
