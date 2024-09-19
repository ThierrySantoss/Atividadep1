package com.programacao1.atividade.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class FuncionarioVeiculoAux {
	
	@Id
	@JoinColumn(name = "funcionario_id")
	private int id;
	@JoinColumn(name = "nome")
	private String nome;
	@JoinColumn(name = "Total")
	private int total;

	public FuncionarioVeiculoAux() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
