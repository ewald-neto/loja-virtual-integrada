package com.autopecasriobranco.lojavirtualintegrada.entities.enums;

public enum TipoMov {
	
	ACERTO("ACERTO"),
	BONUS("BONUS"),
	BRINDE("BRINDE"),
	COMPRA("COMPRA"),
	CONSUMO("CONSUMO"),
	DEVOLUCAO("DEVOLUCAO"),
	EMPRESTIMO("EMPRESTIMO"),
	GARANTIA("GARANTIA"),
	GARANTIA_I("GARANTIA_I"),
	GARANTIA_R("GARANTIA_R"),
	INVENTARIO("INVENTARIO"),
	KITS("KITS"),
	PERDA("PERDA"),
	PREVENDA("PRE-VENDA"),
	REMESSA("REMESSA"),
	TRANSF("TRANSF"),
	TROCA("TROCA"),
	VENDA("VENDA");
	
	private String code;
	
	private TipoMov(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
