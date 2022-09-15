package com.example.demo.login.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nombre;

    @Column
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "perfil")
    private List<Usuario> usuarios;

    @ManyToMany
    private List<Menu> menus;

    public Perfil(long id, String nombre, String description, List<Usuario> usuarios, List<Menu> menus) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.usuarios = usuarios;
        this.menus = menus;
    }

    public Perfil() {
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
