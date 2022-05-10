package com.mateus.gestao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.gestao.doman.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, Integer> {

}
