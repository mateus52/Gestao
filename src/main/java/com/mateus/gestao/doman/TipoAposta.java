package com.mateus.gestao.doman;

public enum TipoAposta {

	SIMPLES(0, "SIMPLES"),
	MULTIPLA(1, "MULTIPLA");
	
	private Integer id;
	private String descricao;
	
	
	private TipoAposta(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoAposta toEnum(Integer id) {
		if(id == null) {
			return null;
		}
		
		for(TipoAposta x : TipoAposta.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ID inválido: " + id);
	}

	
		
	
}
