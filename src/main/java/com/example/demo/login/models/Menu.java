package com.example.demo.login.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @JsonIgnore
    @ManyToMany(mappedBy = "menus")
    private List<Perfil> perfiles;

    public Menu(long id, String nombre, String descripcion, List<Perfil> perfiles) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.perfiles = perfiles;
    }

    public Menu() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
}
