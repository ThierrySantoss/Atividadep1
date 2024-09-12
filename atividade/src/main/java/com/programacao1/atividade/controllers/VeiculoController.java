package com.programacao1.atividade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacao1.atividade.model.entities.veiculo.Veiculo;
import com.programacao1.atividade.model.repositories.VeiculoRepository;

@RestController
@RequestMapping("/consecionaria/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@PostMapping
	public Veiculo novoVeiculo(Veiculo veiculo) {

		veiculoRepository.save(veiculo);
		return veiculo;
	}

	@GetMapping("/obterCarroPorAno")
	public Iterable<Veiculo> obterCarroPorAno(String ano) {
		return veiculoRepository.obterCarrosDeUmAno(ano);
	}

	@GetMapping("/obterCarroPorModelo")
	public Iterable<Veiculo> obterCarroPorModelo(String modelo) {
		return veiculoRepository.obterCarrosPorModelo(modelo);
	}

	@GetMapping("/obterCarrosComMaiorKm")
	public Iterable<Veiculo> obterCarrosComMaiorKm() {
		Pageable page = PageRequest.of(0, 3);
		return veiculoRepository.obterCarrosComMaiorKm(page);
	}

}
