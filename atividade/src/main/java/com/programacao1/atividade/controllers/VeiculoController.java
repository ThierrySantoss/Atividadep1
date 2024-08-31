package com.programacao1.atividade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacao1.atividade.model.entities.veiculo.Veiculo;
import com.programacao1.atividade.model.repositories.VeiculoRepository;

@RestController
@RequestMapping("/consecionaria")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@PostMapping("/veiculo")
	public Veiculo novoVeiculo(Veiculo veiculo) {					
		veiculoRepository.save(veiculo);
		return veiculo;
	}

}
