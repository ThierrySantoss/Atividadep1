package com.programacao1.atividade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacao1.atividade.model.entities.veiculo.Veiculo;
import com.programacao1.atividade.model.repositories.VeiculoRepository;

@RestController
@RequestMapping("/consecionaria")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@PostMapping("/veiculo")
	public Veiculo novoVeiculo(
			@RequestParam String modelo,
			@RequestParam String marca,
			@RequestParam String categoria,
			@RequestParam String anoDeFabricacao,
			@RequestParam String tipoCombustivel,
			@RequestParam int quantidadePassageiros,
			@RequestParam String habilitacao,
			@RequestParam String placa,
			@RequestParam double quilometragem) {
		
		Veiculo novoVeiculo = new Veiculo(modelo, marca, categoria, anoDeFabricacao, tipoCombustivel, quantidadePassageiros, habilitacao, placa, quilometragem);						
		veiculoRepository.save(novoVeiculo);
		return novoVeiculo;
	}

}
