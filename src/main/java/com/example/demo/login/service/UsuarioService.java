package com.example.demo.login.service;


import com.example.demo.login.models.Usuario;
import com.example.demo.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioService() {
    }

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(String id) throws Exception {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        }else{
            throw new Exception("Usuario No Existe");
        }
    }

    public Usuario saveUsuario(Usuario usuario_param){
        return usuarioRepository.save(usuario_param);
    }

    public Usuario putUsuario(Usuario usuario_param){
        return usuarioRepository.save(usuario_param);
    }

    public Usuario patchUsuario(Usuario usuario_param, String id) throws Exception {
        try {
            Usuario usuarioBd = getUsuario(id);

            if(usuario_param.getNombrePersona() != null){
                usuarioBd.setNombrePersona(usuario_param.getNombrePersona());
            }
            if(usuario_param.getPassword() != null){
                usuarioBd.setPassword(usuario_param.getPassword());
            }

            return saveUsuario(usuarioBd);

        } catch (Exception e) {
            throw new Exception("Usuario no se actualizo, porque no existe");
        }
    }

    public String delete(String id){
        usuarioRepository.deleteById(id);
        return "Usuario eliminado Exitosamente";
    }

}
