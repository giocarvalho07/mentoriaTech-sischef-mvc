package com.sischefmanager.model;

public enum Categoria {

	MASSAS("Massas"),
	HAMBURGUERES("Hamburgueres"),
	BRASILEIRA("Brasileira"),
	JAPONESA("Japonesa"),
	MEXICANA("Mexicana"),
	BEBIDAS("Bebidas");
	
	private String categoria;

	private Categoria (String categoria) {
		this.categoria = categoria;
	}
	
}
