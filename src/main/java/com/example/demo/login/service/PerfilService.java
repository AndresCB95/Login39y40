package com.example.demo.login.service;


import com.example.demo.login.models.Perfil;
import com.example.demo.login.models.Persona;
import com.example.demo.login.repository.PerfilRepository;
import com.example.demo.login.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> getPefiles(){
        return perfilRepository.findAll();
    }

    public Perfil getPerfil(Long id) throws Exception {
        Optional<Perfil> perfilOptional = perfilRepository.findById(id);
        if(perfilOptional.isPresent()){
            return perfilOptional.get();
        }else{
            throw new Exception("Perfil No Existe");
        }
    }

    public Perfil savePerfil(Perfil perfil_param){
        return perfilRepository.save(perfil_param);
    }

    public Perfil putPerfil(Perfil perfil_param){
        return perfilRepository.save(perfil_param);
    }

    public Perfil patchPerfil(Perfil perfil_param, Long id) throws Exception {
        try {
            Perfil perfilDb = getPerfil(id);

            if(perfil_param.getNombre() != null){
                perfilDb.setNombre(perfil_param.getNombre());
            }
            if(perfil_param.getDescription() != null){
                perfilDb.setDescription(perfil_param.getDescription());
            }

            return savePerfil(perfilDb);

        } catch (Exception e) {
            throw new Exception("Perfil no se actualizo, porque no existe");
        }
    }

    public String delete(Long id){
        perfilRepository.deleteById(id);
        return "Perfil eliminado Exitosamente";
    }

}
