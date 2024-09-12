package com.programacao1.atividade.model.entities.funcionario;

public enum Penalizacao {
	RestricaoDeConducaoDeVeículo(0, "Restricao De Conducao De Veículo"),
	RestricaoNaAreaDeJogos(1, "Restricao Na Area De Jogos"),
	PerdaDeAniversarioPremiado(2, "Perda De Aniversario Premiado"),
	ImpossibilidadeDeConducao(3, "Impossibilidade De Conducao");

	private int id;
	private String desc;

	private Penalizacao(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
