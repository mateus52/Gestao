package com.mateus.gestao.doman;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Movimentacao")
public class Movimentacao implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double deposito;
	private Double saque;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	
	public Movimentacao() {
		super();
	}


	public Movimentacao(Integer id, Double deposito, Double saque, Usuario usuario) {
		super();
		this.id = id;
		this.deposito = deposito;
		this.saque = saque;
		this.usuario = usuario;
		this.setDate(LocalDateTime.now());
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
