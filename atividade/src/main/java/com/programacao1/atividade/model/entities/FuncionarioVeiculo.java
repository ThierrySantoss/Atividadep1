package com.programacao1.atividade.model.entities;

import java.time.LocalDateTime;

import com.programacao1.atividade.model.entities.funcionario.Funcionario;
import com.programacao1.atividade.model.entities.veiculo.Veiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FuncionarioVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	private LocalDateTime dataSaida;

	private LocalDateTime dataChegada;

	public FuncionarioVeiculo() {

	}

	public FuncionarioVeiculo(Funcionario funcionario, Veiculo veiculo) {
		super();
		this.funcionario = funcionario;
		this.veiculo = veiculo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public LocalDateTime getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(LocalDateTime dataChegada) {
		this.dataChegada = dataChegada;
	}

}
