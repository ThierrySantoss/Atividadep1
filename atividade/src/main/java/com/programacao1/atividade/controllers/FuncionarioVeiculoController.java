package com.programacao1.atividade.controllers;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacao1.atividade.model.entities.FuncionarioVeiculo;
import com.programacao1.atividade.model.entities.funcionario.Funcionario;
import com.programacao1.atividade.model.entities.veiculo.Veiculo;
import com.programacao1.atividade.model.repositories.FuncionarioVeiculoRepository;

@RestController
@RequestMapping("/consecionaria")
public class FuncionarioVeiculoController {
	
	@Autowired
	FuncionarioVeiculoRepository funcionarioVeiculoRepository;
	
	@PostMapping("/funcionarioVeiculo")
	public FuncionarioVeiculo sairComOCarro(@RequestParam Funcionario funcionario,@RequestParam Veiculo veiculo) {
		SimpleDateFormat novaData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		FuncionarioVeiculo fc = new FuncionarioVeiculo(funcionario, veiculo);
		fc.setDataSaida(String.format("%s", novaData));
		funcionarioVeiculoRepository.save(fc);
		
		
		return fc;
	}

}
