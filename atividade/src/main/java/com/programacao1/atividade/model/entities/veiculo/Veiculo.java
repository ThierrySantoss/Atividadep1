package com.programacao1.atividade.model.entities.veiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.programacao1.atividade.model.entities.FuncionarioVeiculo;
import com.programacao1.atividade.validators.AnoDeFabricacaoValidador;
import com.programacao1.atividade.validators.HabilitacaoVeiculoValidador;
import com.programacao1.atividade.validators.PlacaValidador;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String Chave;
	// TODO : ver com o professor, não achei outra forma.

	@NotBlank
	private String modeloVeiculo;

	@NotBlank
	private String marcaDoVeiculo;

	@NotNull(message = "Categoria não pode ser nulo")
	private Categoria categoriaDoVeiculo;

	@AnoDeFabricacaoValidador
	private Integer anoDeFabricacaoDoVeiculo;

	private LocalDate anoDeCompraDoVeiculo;

	@NotNull(message = "Combustivel não pode ser null")
	private TipoCombustivel tipoCombustivelDoVeiculo;

	@Min(1)
	@Max(50)
	private int quantidadePassageirosDoVeiculo;

	@HabilitacaoVeiculoValidador
	private Habilitacao habilitacaoDoVeiculo;

	@PlacaValidador
	private String placaDoVeiculo;

	@Min(0)
	private double quilometragemDoVeiculo;

	@OneToMany(mappedBy = "veiculo", cascade = CascadeType.PERSIST)
	@JsonIgnore
	List<FuncionarioVeiculo> funcionarios = new ArrayList<>();

	public Veiculo() {

	}

	public Veiculo(String modeloVeiculo, String marcaDoVeiculo, Categoria categoriaDoVeiculo,
			Integer anoDeFabricacaoDoVeiculo, TipoCombustivel tipoCombustivelDoVeiculo,
			int quantidadePassageirosDoVeiculo, Habilitacao habilitacaoDoVeiculo, String placaDoVeiculo,
			double quilometragemDoVeiculo) {
		super();
		this.modeloVeiculo = modeloVeiculo;
		this.marcaDoVeiculo = marcaDoVeiculo;
		this.categoriaDoVeiculo = categoriaDoVeiculo;
		this.anoDeFabricacaoDoVeiculo = anoDeFabricacaoDoVeiculo;
		this.tipoCombustivelDoVeiculo = tipoCombustivelDoVeiculo;
		this.quantidadePassageirosDoVeiculo = quantidadePassageirosDoVeiculo;
		this.habilitacaoDoVeiculo = habilitacaoDoVeiculo;
		this.placaDoVeiculo = placaDoVeiculo;
		this.quilometragemDoVeiculo = quilometragemDoVeiculo;
	}

	@PostPersist
	public void posPersistencia() {
		// Lógica do método gerarID
		String gerarChave = String.format("%d/%d", this.id, LocalDate.now().getYear());
		this.Chave = gerarChave;

		// Setando o ano de Compra
		this.anoDeCompraDoVeiculo = LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChave() {
		return Chave;
	}

	public void setChave(String chave) {
		Chave = chave;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getMarcaDoVeiculo() {
		return marcaDoVeiculo;
	}

	public void setMarcaDoVeiculo(String marcaDoVeiculo) {
		this.marcaDoVeiculo = marcaDoVeiculo;
	}

	public Categoria getCategoriaDoVeiculo() {
		return categoriaDoVeiculo;
	}

	public void setCategoriaDoVeiculo(Categoria categoriaDoVeiculo) {
		this.categoriaDoVeiculo = categoriaDoVeiculo;
	}

	public Integer getAnoDeFabricacaoDoVeiculo() {
		return anoDeFabricacaoDoVeiculo;
	}

	public void setAnoDeFabricacaoDoVeiculo(Integer anoDeFabricacaoDoVeiculo) {
		this.anoDeFabricacaoDoVeiculo = anoDeFabricacaoDoVeiculo;
	}

	public LocalDate getAnoDeCompraDoVeiculo() {
		return anoDeCompraDoVeiculo;
	}

	public void setAnoDeCompraDoVeiculo(LocalDate anoDeCompraDoVeiculo) {
		this.anoDeCompraDoVeiculo = anoDeCompraDoVeiculo;
	}

	public TipoCombustivel getTipoCombustivelDoVeiculo() {
		return tipoCombustivelDoVeiculo;
	}

	public void setTipoCombustivelDoVeiculo(TipoCombustivel tipoCombustivelDoVeiculo) {
		this.tipoCombustivelDoVeiculo = tipoCombustivelDoVeiculo;
	}

	public int getQuantidadePassageirosDoVeiculo() {
		return quantidadePassageirosDoVeiculo;
	}

	public void setQuantidadePassageirosDoVeiculo(int quantidadePassageirosDoVeiculo) {
		this.quantidadePassageirosDoVeiculo = quantidadePassageirosDoVeiculo;
	}

	public Habilitacao getHabilitacaoDoVeiculo() {
		return habilitacaoDoVeiculo;
	}

	public void setHabilitacaoDoVeiculo(Habilitacao habilitacaoDoVeiculo) {
		this.habilitacaoDoVeiculo = habilitacaoDoVeiculo;
	}

	public String getPlacaDoVeiculo() {
		return placaDoVeiculo;
	}

	public void setPlacaDoVeiculo(String placaDoVeiculo) {
		this.placaDoVeiculo = placaDoVeiculo;
	}

	public double getQuilometragemDoVeiculo() {
		return quilometragemDoVeiculo;
	}

	public void setQuilometragemDoVeiculo(double quilometragemDoVeiculo) {
		this.quilometragemDoVeiculo = quilometragemDoVeiculo;
	}

	public List<FuncionarioVeiculo> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioVeiculo> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
