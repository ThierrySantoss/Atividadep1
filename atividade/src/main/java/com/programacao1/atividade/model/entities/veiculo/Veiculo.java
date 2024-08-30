package com.programacao1.atividade.model.entities.veiculo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculos")
public class Veiculo {
	
	@Id
	private String id;
	private String modelo;
	private String marca;
	private String categoria;
	private String anoDeFabricacao;
	private String anoDeCompra;
	private String tipoCombustivel;
	private int quantidadePassageiros;
	private String habilitacao;
	private String placa;
	private double quilometragem;
	private static final AtomicInteger counter = new AtomicInteger(1);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	
	public Veiculo() {
		
	}
	
	

	public Veiculo(
			String modelo, 
			String marca, 
			String categoria, 
			String anoDeFabricacao,
			String tipoCombustivel, 
			int quantidadePassageiros, 
			String habilitacao, 
			String placa,
			double quilometragem) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.categoria = categoria;
		this.anoDeFabricacao = anoDeFabricacao;
		this.anoDeCompra = String.format("%s", new SimpleDateFormat("dd/MM/yyyy").format(new Date())); 
		this.tipoCombustivel = tipoCombustivel;
		this.quantidadePassageiros = quantidadePassageiros;
		this.habilitacao = habilitacao;
		this.placa = placa;
		this.quilometragem = quilometragem;
	}

	@PrePersist
	    public void gerarId() {
	        String year = sdf.format(new Date());
	        int currentCount = counter.getAndIncrement();
	        this.id = String.format("%02d/%s", currentCount, year);
	    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public void setAnoDeFabricacao(String anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}

	public String getAnoDeCompra() {
		return anoDeCompra;
	}

	public void setAnoDeCompra(String anoDeCompra) {
		this.anoDeCompra = anoDeCompra;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public int getQuantidadePassageiros() {
		return quantidadePassageiros;
	}

	public void setQuantidadePassageiros(int quantidadePassageiros) {
		this.quantidadePassageiros = quantidadePassageiros;
	}

	public String getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}
	
	
	
	

}
