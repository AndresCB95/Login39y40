package com.example.demo.login.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="persona")
public class Persona{

    @Id
    private int numeroIdentificacion;
    @Column
    private String nivelDeEstudio;
    @Column
    private Date fechaNacimiento;
    @OneToOne
    private Usuario usuario;

    public Persona(int numeroIdentificacion, String nivelDeEstudio, Date fechaNacimiento, Usuario usuario) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nivelDeEstudio = nivelDeEstudio;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
    }

    public Persona() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNivelDeEstudio() {
        return nivelDeEstudio;
    }

    public void setNivelDeEstudio(String nivelDeEstudio) {
        this.nivelDeEstudio = nivelDeEstudio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


}
