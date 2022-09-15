package com.example.demo.login.repository;

import com.example.demo.login.models.Persona;
import com.example.demo.login.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    public Persona findByUsuarioNombreUsuario(String id_usuario);

}
