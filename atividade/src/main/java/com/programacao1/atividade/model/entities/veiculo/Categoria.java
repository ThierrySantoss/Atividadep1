package com.programacao1.atividade.model.entities.veiculo;

public enum Categoria {

	MOTO(0), CARRO_PASSEIO(1), UTILITARIO(2), CAMINHAO(3);

	private int id;

	private Categoria(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
