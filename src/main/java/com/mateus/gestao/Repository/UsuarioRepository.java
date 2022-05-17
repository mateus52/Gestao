package com.mateus.gestao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.gestao.doman.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
