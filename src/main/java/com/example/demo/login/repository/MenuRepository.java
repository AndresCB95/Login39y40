package com.example.demo.login.repository;

import com.example.demo.login.models.Menu;
import com.example.demo.login.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {

}
