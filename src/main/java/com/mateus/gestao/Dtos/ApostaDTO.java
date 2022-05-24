package com.mateus.gestao.Dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateus.gestao.doman.Aposta;

public class ApostaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id; 
	
	private Double valor;
	
	private Integer esporte;
	
	private Double odd;
	
	private Integer resultado;
	
	private Integer aposta;
	
	private Integer usuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime date;

	public ApostaDTO() {
		super();
	}
	
	

	public ApostaDTO(Aposta obj) {
		super();
		this.id = obj.getId();
		this.valor = obj.getValor();
		this.esporte = obj.getEsporte().getId();
		this.odd = obj.getOdd();
		this.resultado = obj.getResultado().getId();
		this.aposta = obj.getAposta().getId();
		this.usuario = obj.getUsuario().getId();
		this.date = obj.getDate();
	}



	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getEsporte() {
		return esporte;
	}

	public void setEsporte(Integer esporte) {
		this.esporte = esporte;
	}

	public Double getOdd() {
		return odd;
	}

	public void setOdd(Double odd) {
		this.odd = odd;
	}

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}

	public Integer getAposta() {
		return aposta;
	}

	public void setAposta(Integer aposta) {
		this.aposta = aposta;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
