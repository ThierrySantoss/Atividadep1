package com.programacao1.atividade.model.entities.veiculo;

public enum TipoCombustivel {

	ALCOOL(0), GASOLINA(1), DIESEL(2), ELETRICO(3);

	private int id;

	private TipoCombustivel(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
