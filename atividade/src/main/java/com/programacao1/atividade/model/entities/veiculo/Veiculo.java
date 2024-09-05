package com.programacao1.atividade.model.entities.veiculo;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String idAno;
	// TODO : Ver com o professor se isso ta certo.

	@NotBlank
	private String modeloVeiculo;

	@NotBlank
	private String marcaDoVeiculo;

	@NotBlank
	private String categoriaDoVeiculo;

	@NotBlank
	@Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([1-9][0-9]{3})$", message = "Data deve estar no formato dd/mm/yyy!")
	private String anoDeFabricacaoDoVeiculo;
	// TODO : Implementar um validador para não permitir ano no futuro

	private String anoDeCompraDoVeiculo;

	@NotBlank
	private String tipoCombustivelDoVeiculo;

	@Min(1)
	@Max(50)
	private int quantidadePassageirosDoVeiculo;

	@NotBlank
	@Pattern(regexp = "^[A-E]$", message = "Habilitação válidas: A, B, C, D, E")
	private String habilitacaoDoVeiculo;

	@NotBlank
	@Pattern(regexp = "^([A-Z]{4})([0-9]{3})$", message = "Placa deve conter 4 letras e 3 numeros!")
	private String placaDoVeiculo;

	@Min(0)
	private double quilometragemDoVeiculo;
	
	@OneToMany(mappedBy = "veiculo", cascade = CascadeType.PERSIST)
	List<FuncionarioVeiculo> funcionarios = new ArrayList<>();

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

	public Veiculo() {

	}

	public Veiculo(String modeloVeiculo, String marcaDoVeiculo, String categoriaDoVeiculo,
			String anoDeFabricacaoDoVeiculo, String tipoCombustivelDoVeiculo, int quantidadePassageirosDoVeiculo,
			String habilitacaoDoVeiculo, String placaDoVeiculo, double quilometragemDoVeiculo) {
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
		String year = sdf.format(new Date());
		this.idAno = String.format("%02d/%s", this.id, year);
		this.anoDeCompraDoVeiculo = String.format("%s", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		
		// Lógica do método para restringir anoDeFabricacaoDoVeiculo seja no futuro.
		Integer yearInt = Integer.parseInt(sdf.format(new Date()));
		Integer dataFormatada = Integer.parseInt(this.anoDeFabricacaoDoVeiculo.substring(6, 10));
		if(dataFormatada > yearInt) {
			this.anoDeFabricacaoDoVeiculo = null;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdAno() {
		return idAno;
	}

	public void setIdAno(String idAno) {
		this.idAno = idAno;
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

	public String getCategoriaDoVeiculo() {
		return categoriaDoVeiculo;
	}

	public void setCategoriaDoVeiculo(String categoriaDoVeiculo) {
		this.categoriaDoVeiculo = categoriaDoVeiculo;
	}

	public String getAnoDeFabricacaoDoVeiculo() {
		return anoDeFabricacaoDoVeiculo;
	}

	public void setAnoDeFabricacaoDoVeiculo(String anoDeFabricacaoDoVeiculo) {
		this.anoDeFabricacaoDoVeiculo = anoDeFabricacaoDoVeiculo;
	}

	public String getAnoDeCompraDoVeiculo() {
		return anoDeCompraDoVeiculo;
	}

	public void setAnoDeCompraDoVeiculo(String anoDeCompraDoVeiculo) {
		this.anoDeCompraDoVeiculo = anoDeCompraDoVeiculo;
	}

	public String getTipoCombustivelDoVeiculo() {
		return tipoCombustivelDoVeiculo;
	}

	public void setTipoCombustivelDoVeiculo(String tipoCombustivelDoVeiculo) {
		this.tipoCombustivelDoVeiculo = tipoCombustivelDoVeiculo;
	}

	public int getQuantidadePassageirosDoVeiculo() {
		return quantidadePassageirosDoVeiculo;
	}

	public void setQuantidadePassageirosDoVeiculo(int quantidadePassageirosDoVeiculo) {
		this.quantidadePassageirosDoVeiculo = quantidadePassageirosDoVeiculo;
	}

	public String getHabilitacaoDoVeiculo() {
		return habilitacaoDoVeiculo;
	}

	public void setHabilitacaoDoVeiculo(String habilitacaoDoVeiculo) {
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
