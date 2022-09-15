package com.example.demo.login.repository;

import com.example.demo.login.models.Perfil;
import com.example.demo.login.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long> {

    public Perfil findByNombreAndUsuarioNombreUsuarioAndUsuarioPersonaNumeroIdentificacion(String nombre, String nombreUsuario);
}
