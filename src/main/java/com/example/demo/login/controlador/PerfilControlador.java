package com.example.demo.login.controlador;

import com.example.demo.login.models.Perfil;
import com.example.demo.login.models.Persona;
import com.example.demo.login.models.UsuarioResponse;
import com.example.demo.login.service.PerfilService;
import com.example.demo.login.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PerfilControlador {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/perfiles")
    public ResponseEntity<List<Perfil>> getPerfiles(){
        return new ResponseEntity<List<Perfil>>(
                perfilService.getPefiles(),
                HttpStatus.OK
        );
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity<Object> getPerfil(@PathVariable Long id){

        try {
            System.out.println("Metodo Url");
            Perfil perfil = perfilService.getPerfil(id);
            return new ResponseEntity<>(perfil,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/perfil")
    public ResponseEntity<Object> getPerfiles(@RequestParam Long id){
        try {
            System.out.println("Metodo Url");
            Perfil perfil = perfilService.getPerfil(id);
            return new ResponseEntity<>(perfil,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/perfil")
    public ResponseEntity<UsuarioResponse> postPerfil(@RequestBody Perfil perfil){
        return new ResponseEntity<>(

                new UsuarioResponse("perfil Creado Exitosamente",
                perfilService.savePerfil(perfil))

                ,HttpStatus.OK);
    }

    @PutMapping("/perfil")
    public ResponseEntity<UsuarioResponse> putUsuario(@RequestBody Perfil perfil){
        return new ResponseEntity<>(
        new UsuarioResponse("Perfil Actualizado Exitosamente", perfilService.putPerfil(perfil))
        ,HttpStatus.OK);
    }

    @PatchMapping("/perfil/{id}")
    public ResponseEntity<UsuarioResponse> patch(@RequestBody Perfil perfil, @PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    new UsuarioResponse("Actualizacion Exitosa", perfilService.patchPerfil(perfil, id)),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new UsuarioResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping("/perfil/{id}")
    public ResponseEntity<UsuarioResponse> delete(@PathVariable Long id){
        return new ResponseEntity<>(

                new UsuarioResponse(perfilService.delete(id), null),
                HttpStatus.OK
        );
    }


}
