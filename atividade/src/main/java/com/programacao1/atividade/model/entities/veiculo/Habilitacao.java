package com.programacao1.atividade.model.entities.veiculo;

public enum Habilitacao {

	A("A"), B("B"), C("B"), D("D"), E("E");

	private String codigo;

	private Habilitacao(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
