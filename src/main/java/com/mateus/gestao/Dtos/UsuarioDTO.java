package com.mateus.gestao.Dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.mateus.gestao.doman.Usuario;

public class UsuarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O campo nome e requerido!")
	private String nome;
	
	private Double saldo;
	
	@NotEmpty(message = "O campo email e requerido!")
	private String email;
	
	
	public UsuarioDTO() {
		super();
	}


	public UsuarioDTO(Usuario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.saldo = obj.getSaldo();
		this.email =obj.getEmail();
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


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
