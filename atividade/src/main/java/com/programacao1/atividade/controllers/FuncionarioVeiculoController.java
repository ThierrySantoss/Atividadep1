package com.programacao1.atividade.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacao1.atividade.model.entities.FuncionarioVeiculo;
import com.programacao1.atividade.model.entities.funcionario.Funcionario;
import com.programacao1.atividade.model.entities.veiculo.Veiculo;
import com.programacao1.atividade.model.repositories.FuncionarioRepository;
import com.programacao1.atividade.model.repositories.FuncionarioVeiculoRepository;
import com.programacao1.atividade.model.repositories.VeiculoRepository;

@RestController
@RequestMapping("/consecionaria/funcionarioVeiculo")
public class FuncionarioVeiculoController {

	@Autowired
	FuncionarioVeiculoRepository funcionarioVeiculoRepository;

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	VeiculoRepository veiculoRepository;

	@PostMapping
	public FuncionarioVeiculo novaSaida(Funcionario funcionario, Veiculo veiculo) {

		Optional<Funcionario> funcionarioExiste = funcionarioRepository.findById(funcionario.getId());
		Optional<Veiculo> veiculoExiste = veiculoRepository.findById(veiculo.getId());

		if (funcionarioExiste.get().getHabilitacaoFuncionario().contains(veiculoExiste.get().getHabilitacaoDoVeiculo())
				&& (funcionarioExiste.get().getDataPenalizacao() == null
						|| funcionarioExiste.get().getDataPenalizacao().isBefore(LocalDate.now()))) {
			FuncionarioVeiculo novo = new FuncionarioVeiculo(funcionario, veiculo);
			novo.setDataSaida(LocalDateTime.now());
			funcionarioVeiculoRepository.save(novo);
			return novo;

		} else {
			return null;
		}

	}

	@GetMapping
	public FuncionarioVeiculo obterFuncionarioVeiculoId(@RequestParam int id) {
		return funcionarioVeiculoRepository.findById(id).get();
	}

	@PutMapping
	public FuncionarioVeiculo novaChegada(int id, double quilometragemDoVeiculo) {

		Optional<FuncionarioVeiculo> funcionarioVeiculoExiste = funcionarioVeiculoRepository.findById(id);
		FuncionarioVeiculo funcionarioVeiculoAtualizar = funcionarioVeiculoExiste.get();
		if (funcionarioVeiculoExiste.isPresent()) {
			if (quilometragemDoVeiculo > funcionarioVeiculoAtualizar.getVeiculo().getQuilometragemDoVeiculo()) {

				funcionarioVeiculoAtualizar.setDataChegada(LocalDateTime.now());
				funcionarioVeiculoAtualizar.getVeiculo().setQuilometragemDoVeiculo(quilometragemDoVeiculo);
				funcionarioVeiculoRepository.save(funcionarioVeiculoAtualizar);
				return funcionarioVeiculoAtualizar;
			} else {
				return null;
			}

		} else {
			return null;
		}

	}

	@GetMapping("/obterMotoristasqueMaisDirigiram")
	public ResponseEntity<?> obterMotoristasqueMaisDirigiram() {

		Pageable page = PageRequest.of(0, 3);
		Page<Object[]> resultado = funcionarioVeiculoRepository.obterMotoristasqueMaisDirigiram(page);
		return ResponseEntity.ok(resultado);
	}

}
