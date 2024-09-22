package com.programacao1.atividade.model.entities.funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.programacao1.atividade.model.entities.FuncionarioVeiculo;
import com.programacao1.atividade.model.entities.veiculo.Habilitacao;
import com.programacao1.atividade.validators.DataNascimentoValidador;
import com.programacao1.atividade.validators.HabilitacaoFuncionarioValidador;
import com.programacao1.atividade.validators.RgValidador;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	private String nome;

	@DataNascimentoValidador
	private LocalDate dataNascimento;

	@RgValidador
	private String rg;

	@HabilitacaoFuncionarioValidador
	private List<Habilitacao> habilitacaoFuncionario;

	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.PERSIST)
	@JsonIgnore
	List<FuncionarioVeiculo> veiculos = new ArrayList<>();

	@ElementCollection
	private List<Penalizacao> penalizacao = new ArrayList<Penalizacao>();

	LocalDate dataPenalizacao;

	public Funcionario() {

	}

	public Funcionario(@NotBlank String nome, LocalDate dataNascimento, String rg,
			List<Habilitacao> habilitacaoFuncionario) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.habilitacaoFuncionario = habilitacaoFuncionario;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public List<Habilitacao> getHabilitacaoFuncionario() {
		return habilitacaoFuncionario;
	}

	public void setHabilitacaoFuncionario(List<Habilitacao> habilitacaoFuncionario) {
		this.habilitacaoFuncionario = habilitacaoFuncionario;
	}

	public List<FuncionarioVeiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<FuncionarioVeiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Penalizacao> getPenalizacao() {
		return penalizacao;
	}

	public void setPenalizacao(List<Penalizacao> penalizacao) {
		this.penalizacao = penalizacao;
	}

	public LocalDate getDataPenalizacao() {
		return dataPenalizacao;
	}

	public void setDataPenalizacao(LocalDate dataPenalizacao) {
		this.dataPenalizacao = dataPenalizacao;
	}

	public void adicionarPenalização(Penalizacao penalização) {
		this.penalizacao.add(penalização);
	}

}
