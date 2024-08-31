package com.programacao1.atividade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public Funcionario novoFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);		
		return funcionario;
	}
	
	@GetMapping
	public Funcionario obterFuncionarioId(@RequestParam int id) {
		return funcionarioRepository.findById(id).get();
	}

}
