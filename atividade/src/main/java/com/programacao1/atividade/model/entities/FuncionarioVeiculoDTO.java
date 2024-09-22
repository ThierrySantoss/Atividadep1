package com.programacao1.atividade.model.entities;

public class FuncionarioVeiculoDTO {

	private String nome;
	private Long total;

	public FuncionarioVeiculoDTO() {

	}

	public FuncionarioVeiculoDTO(String nome, Long total) {
		this.nome = nome;
		this.total = total;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
