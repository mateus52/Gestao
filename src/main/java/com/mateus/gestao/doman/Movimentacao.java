package com.mateus.gestao.doman;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movimentacao")
public class Movimentacao {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double deposito;
	private Double saque;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	
	public Movimentacao() {
		super();
	}


	public Movimentacao(Integer id, Double deposito, Double saque) {
		super();
		this.id = id;
		this.deposito = deposito;
		this.saque = saque;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	

}
