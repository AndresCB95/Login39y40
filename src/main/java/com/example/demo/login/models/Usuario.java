package com.example.demo.login.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private String nombreUsuario;
    @Column
    private String password;
    @Column
    private String nombrePersona;
    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private Persona persona;

    @ManyToOne
    private Perfil perfil;

    public Usuario(String nombreUsuario, String password, String nombrePersona, Persona persona, Perfil perfil) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombrePersona = nombrePersona;
        this.persona = persona;
        this.perfil = perfil;
    }

    public Usuario() {
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}
