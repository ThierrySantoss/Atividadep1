package com.programacao1.atividade.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/atribuirPenalizacao")
	public Funcionario atribuirPenalizacao(int id, int penalizacao) {
		Optional<Funcionario> funcionariooExiste = funcionarioRepository.findById(id);
		Funcionario funcionarioAtualizar = funcionariooExiste.get();
		
		switch (penalizacao) {
		case 1: {
			if(funcionarioAtualizar.getPenalizacao() == null) {
				LocalDate penalizacao1 = LocalDate.now().plus(1, ChronoUnit.MONTHS);
				funcionarioAtualizar.setPenalizacao(penalizacao1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				funcionarioRepository.save(funcionarioAtualizar);
				break;
			
			}
		}
		
		}
		
		return funcionarioAtualizar;
		
	
	}

}
