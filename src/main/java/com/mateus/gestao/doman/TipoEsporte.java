package com.mateus.gestao.doman;

public enum TipoEsporte {

	BASQUETE(0, "BASQUETE"),
	FUTEBOL(1, "FUTEBOL");
	
	private Integer id;
	private String descricao;
	
	
	private TipoEsporte(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	public static TipoEsporte toEnum(Integer id) {
		if(id == null) {
			return null;
		}
		
		for(TipoEsporte x : TipoEsporte.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ID inválido: " + id);
	}



	
}
