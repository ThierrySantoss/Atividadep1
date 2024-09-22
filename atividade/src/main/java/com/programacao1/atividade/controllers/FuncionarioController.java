package com.programacao1.atividade.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacao1.atividade.model.entities.funcionario.Funcionario;
import com.programacao1.atividade.model.entities.funcionario.Penalizacao;
import com.programacao1.atividade.model.repositories.FuncionarioRepository;

@RestController
@RequestMapping("/consecionaria/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@PostMapping
	public Funcionario novoFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return funcionario;
	}

	@GetMapping
	public Funcionario obterFuncionarioId(@RequestParam int id) {
		return funcionarioRepository.findById(id).get();
	}

	@GetMapping("/obterFuncionariosMesNaoPenalizacao")
	public Iterable<Funcionario> obterFuncionariosMesNaoPenalizacao(int mes) {
		return funcionarioRepository.obterFuncionariosMesNaoPenalizacao(mes);
	}

	@GetMapping("/obterFuncionarioPenalizacao")
	public Iterable<Funcionario> obterFuncionarioPenalizacao() {
		return funcionarioRepository.obterFuncionarioPenalizacao();
	}

	@PutMapping
	public Funcionario atribuirPenalizacao(int id, Penalizacao penalizacao) {
		Optional<Funcionario> funcionariooExiste = funcionarioRepository.findById(id);
		Funcionario funcionarioAtualizar = funcionariooExiste.get();

		funcionarioAtualizar.adicionarPenalização(penalizacao);

		if (penalizacao == Penalizacao.RestricaoDeConducaoDeVeículo) {
			funcionarioAtualizar.setDataPenalizacao(LocalDate.now().plusMonths(1));
		} else if (penalizacao == Penalizacao.RestricaoNaAreaDeJogos) {
			funcionarioAtualizar.setDataPenalizacao(LocalDate.now().plusWeeks(1));
		} else if (penalizacao == Penalizacao.PerdaDeAniversarioPremiado) {
			funcionarioAtualizar.setDataPenalizacao(LocalDate.now().plusYears(1));
		} else if (penalizacao == Penalizacao.ImpossibilidadeDeConducao) {
			funcionarioAtualizar.setDataPenalizacao(LocalDate.now().plusYears(999));
		}

		funcionarioRepository.save(funcionarioAtualizar);
		return funcionarioAtualizar;
	}

}
