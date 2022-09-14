package com.example.demo.login.controlador;

import com.example.demo.login.models.Usuario;
import com.example.demo.login.models.UsuarioResponse;
import com.example.demo.login.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity<List<Usuario>>(
                usuarioService.getUsuarios(),
                HttpStatus.OK
        );
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object> getUsuario(@PathVariable String id){

        try {
            System.out.println("Metodo Url");
            Usuario usuario = usuarioService.getUsuario(id);
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario")
    public ResponseEntity<Object> getUsuarios(@RequestParam String id){
        try {
            System.out.println("Metodo Query");
            Usuario usuario = usuarioService.getUsuario(id);
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/usuario")
    public ResponseEntity<UsuarioResponse> postUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(

                new UsuarioResponse("Usuario Creado Exitosamente",
                usuarioService.saveUsuario(usuario))

                ,HttpStatus.OK);
    }

    @PutMapping("/usuario")
    public ResponseEntity<UsuarioResponse> putUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(
        new UsuarioResponse("Usuario Actualizado Exitosamente", usuarioService.putUsuario(usuario))
        ,HttpStatus.OK);
    }

    @PatchMapping("/usuario/{id}")
    public ResponseEntity<UsuarioResponse> patch(@RequestBody Usuario usuario, @PathVariable String id){
        try {
            return new ResponseEntity<>(
                    new UsuarioResponse("Actualizacion Exitosa", usuarioService.patchUsuario(usuario, id)),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new UsuarioResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<UsuarioResponse> delete(@PathVariable String id){
        return new ResponseEntity<>(

                new UsuarioResponse(usuarioService.delete(id), null),
                HttpStatus.OK
        );
    }


}
