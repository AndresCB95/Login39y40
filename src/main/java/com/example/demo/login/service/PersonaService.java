package com.example.demo.login.service;


import com.example.demo.login.models.Persona;
import com.example.demo.login.models.Usuario;
import com.example.demo.login.repository.PersonaRepository;
import com.example.demo.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }

    public Persona getPersona(Integer id) throws Exception {
        Optional<Persona> personalOptional = personaRepository.findById(id);
        if(personalOptional.isPresent()){
            return personalOptional.get();
        }else{
            throw new Exception("Persona No Existe");
        }
    }

    public Persona getPeronaByUsuarioId(String idUsuario){
        return personaRepository.findByUsuarioNombreUsuario(idUsuario);
    }

    public Persona savePersona(Persona persona_param){
        return personaRepository.save(persona_param);
    }

    public Persona putPersona(Persona persona_param){
        return personaRepository.save(persona_param);
    }

    public Persona patchPersona(Persona persona_param, Integer id) throws Exception {
        try {
            Persona personaDb = getPersona(id);

            if(persona_param.getNivelDeEstudio() != null){
                personaDb.setNivelDeEstudio(persona_param.getNivelDeEstudio());
            }
            if(persona_param.getFechaNacimiento() != null){
                personaDb.setFechaNacimiento(persona_param.getFechaNacimiento());
            }

            return savePersona(personaDb);

        } catch (Exception e) {
            throw new Exception("Persona no se actualizo, porque no existe");
        }
    }

    public String delete(Integer id){
        personaRepository.deleteById(id);
        return "Persona eliminado Exitosamente";
    }

}
