package com.mateus.gestao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.gestao.doman.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

}
