package com.mateus.gestao.doman;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private Double saldo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Movimentacao> movimentacaos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Aposta> apostas = new ArrayList<>();
	
	
	public Usuario() {
	}
	


	public Usuario(Integer id, String nome, String email, Double saldo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;

	}





	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public List<Movimentacao> getMovimentacaos() {
		return movimentacaos;
	}


	public List<Aposta> getApostas() {
		return apostas;
	}
	
	

}
