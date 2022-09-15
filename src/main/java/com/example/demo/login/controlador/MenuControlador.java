package com.example.demo.login.controlador;

import com.example.demo.login.models.Menu;
import com.example.demo.login.models.Perfil;
import com.example.demo.login.models.UsuarioResponse;
import com.example.demo.login.service.MenuService;
import com.example.demo.login.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuControlador {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menus")
    public ResponseEntity<List<Menu>> getMenus(){
        return new ResponseEntity<List<Menu>>(
                menuService.getMenus(),
                HttpStatus.OK
        );
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<Object> getMenu(@PathVariable Long id){

        try {
            System.out.println("Metodo Url");
            Menu menu = menuService.getMenu(id);
            return new ResponseEntity<>(menu,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/menu")
    public ResponseEntity<Object> getMenus(@RequestParam Long id){
        try {
            System.out.println("Metodo Url");
            Menu menu = menuService.getMenu(id);
            return new ResponseEntity<>(menu,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/menu")
    public ResponseEntity<UsuarioResponse> postPerfil(@RequestBody Menu menu){
        return new ResponseEntity<>(

                new UsuarioResponse("Menu Creado Exitosamente",
                menuService.saveMenu(menu))

                ,HttpStatus.OK);
    }

    @PutMapping("/menu")
    public ResponseEntity<UsuarioResponse> putUsuario(@RequestBody Menu menu){
        return new ResponseEntity<>(
        new UsuarioResponse("Menu Actualizado Exitosamente", menuService.putMenu(menu))
        ,HttpStatus.OK);
    }

    @PatchMapping("/menu/{id}")
    public ResponseEntity<UsuarioResponse> patch(@RequestBody Menu menu, @PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    new UsuarioResponse("Actualizacion Exitosa", menuService.patchMenu(menu, id)),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new UsuarioResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<UsuarioResponse> delete(@PathVariable Long id){
        return new ResponseEntity<>(

                new UsuarioResponse(menuService.delete(id), null),
                HttpStatus.OK
        );
    }


}
