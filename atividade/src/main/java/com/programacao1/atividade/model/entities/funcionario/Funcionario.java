package com.programacao1.atividade.model.entities.funcionario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.programacao1.atividade.model.entities.FuncionarioVeiculo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Nome não pode estar em branco!")
	private String nome;

	@NotBlank
	@Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([1-9][0-9]{3})$", message = "Data deve estar no formato dd/mm/yyy!")
	private String dataNascimento;

	@NotBlank
	@Pattern(regexp = "\\d{9}", message = "Rg Invalido, deve conter 9 digitos e apenas numeros! ")
	private String rg;
	// TODO : Ver com o professor um validador para rg

	@Pattern(regexp = "^[A-E]+$", message = "Habilitação válidas: A, B, C, D, E")
	private String habilitaçãoFuncionario;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.PERSIST)
	List<FuncionarioVeiculo> veiculos = new ArrayList<>();
	
	private String penalizacao;
	

	public Funcionario() {

	}

	public Funcionario(String nome, String dataNascimento, String rg, String habilitaçãoFuncionario) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.habilitaçãoFuncionario = habilitaçãoFuncionario;
	}
	
	@PostPersist
	public void posPersistencia() {
		// Lógica do método para restringir dataNascimento seja no futuro.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Integer yearInt = Integer.parseInt(sdf.format(new Date()));
		Integer dataFormatada = Integer.parseInt(this.dataNascimento.substring(6, 10));
		if(dataFormatada > yearInt) {
			this.dataNascimento = null;
		}
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getHabilitaçãoFuncionario() {
		return habilitaçãoFuncionario;
	}

	public void setHabilitaçãoFuncionario(String habilitaçãoFuncionario) {
		this.habilitaçãoFuncionario = habilitaçãoFuncionario;
	}

	public List<FuncionarioVeiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<FuncionarioVeiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public String getPenalizacao() {
		return penalizacao;
	}

	public void setPenalizacao(String penalizacao) {
		this.penalizacao = penalizacao;
	}
	
	

}
