package com.programacao1.atividade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacao1.atividade.model.entities.funcionario.Funcionario;
import com.programacao1.atividade.model.repositories.FuncionarioRepository;

@RestController
@RequestMapping("/consecionaria")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@PostMapping("/funcionario")
	public Funcionario novoFuncionario(
			@RequestParam String nome,
			@RequestParam String dataNascimento,
			@RequestParam String rg,
			@RequestParam String habilitacao) {
		
		Funcionario funcionario = new Funcionario(nome, dataNascimento, rg, habilitacao);
		funcionarioRepository.save(funcionario);		
		return funcionario;
	}

}
