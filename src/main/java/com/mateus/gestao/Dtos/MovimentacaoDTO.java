package com.mateus.gestao.Dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.mateus.gestao.doman.Movimentacao;

public class MovimentacaoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	

	private Double deposito;
	

	private Double saque;
	
	private LocalDateTime date;
	
	private Integer usuario;

	public MovimentacaoDTO() {
		super();
	}

	public MovimentacaoDTO(Movimentacao obj) {
		super();
		this.deposito = obj.getDeposito();
		this.saque = obj.getSaque();
		this.date = obj.getDate();
		this.usuario = obj.getUsuario().getId();
		this.id = obj.getId();
	}

	public Double getDeposito() {
		return deposito;
	}

	public void setDeposito(Double deposito) {
		this.deposito = deposito;
	}

	public Double getSaque() {
		return saque;
	}

	public void setSaque(Double saque) {
		this.saque = saque;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	
}
