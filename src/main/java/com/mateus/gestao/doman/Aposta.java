package com.mateus.gestao.doman;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Aposta")
public class Aposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valor;
	
	private Integer esporte;
	
	private Double odd;
	
	private Integer resultado;
	
	private Integer aposta;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Aposta() {
		super();
		this.setDate(LocalDateTime.now());
	}

	public Aposta(Integer id, Double valor, TipoEsporte esporte, Double odd, TipoResultado resultado,
			TipoAposta aposta) {
		super();
		this.id = id;
		this.valor = valor;
		this.esporte = (esporte == null) ? 0 : esporte.getId();
		this.odd = odd;
		this.resultado = (resultado == null) ? 0 : resultado.getId();;
		this.aposta = (aposta == null) ? 0 : aposta.getId();;
		this.setDate(LocalDateTime.now());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoEsporte getEsporte() {
		return TipoEsporte.toEnum(this.esporte);
	}

	public void setEsporte(TipoEsporte esporte) {
		this.esporte = esporte.getId();
	}

	public Double getOdd() {
		return odd;
	}

	public void setOdd(Double odd) {
		this.odd = odd;
	}

	public TipoResultado getResultado() {
		return TipoResultado.toEnum(this.resultado);
	}

	public void setResultado(TipoResultado resultado) {
		this.resultado = resultado.getId();
	}

	public TipoAposta getAposta() {
		return TipoAposta.toEnum(this.aposta);
	}

	public void setAposta(TipoAposta aposta) {
		this.aposta = aposta.getId();
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	

}
