package com.mateus.gestao.doman;

public enum TipoResultado {

	GREEN(0, "GREEN"),
	RED(1, "RED"),
	ANULADA(2,"ANULADA");
	
	private Integer id;
	private String descricao;
	
	
	private TipoResultado(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static TipoResultado toEnum(Integer id) {
		if(id == null) {
			return null;
		}
		
		for(TipoResultado x : TipoResultado.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ID inválido: " + id);
	}


}
