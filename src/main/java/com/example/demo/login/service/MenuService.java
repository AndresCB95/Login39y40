package com.example.demo.login.service;


import com.example.demo.login.models.Menu;
import com.example.demo.login.models.Perfil;
import com.example.demo.login.repository.MenuRepository;
import com.example.demo.login.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getMenus(){
        return menuRepository.findAll();
    }

    public Menu getMenu(Long id) throws Exception {
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if(menuOptional.isPresent()){
            return menuOptional.get();
        }else{
            throw new Exception("Menu No Existe");
        }
    }

    public Menu saveMenu(Menu menu_param){
        return menuRepository.save(menu_param);
    }

    public Menu putMenu(Menu menu_param){
        return menuRepository.save(menu_param);
    }

    public Menu patchMenu(Menu menu_param, Long id) throws Exception {
        try {
            Menu menulDb = getMenu(id);

            if(menu_param.getNombre() != null){
                menulDb.setNombre(menu_param.getNombre());
            }
            if(menu_param.getDescripcion() != null){
                menulDb.setDescripcion(menu_param.getDescripcion());
            }

            return saveMenu(menulDb);

        } catch (Exception e) {
            throw new Exception("Menu no se actualizo, porque no existe");
        }
    }

    public String delete(Long id){
        menuRepository.deleteById(id);
        return "Menu eliminado Exitosamente";
    }

}
