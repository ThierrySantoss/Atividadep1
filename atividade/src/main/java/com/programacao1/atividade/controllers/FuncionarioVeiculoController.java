package com.programacao1.atividade.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/consecionaria")
public class FuncionarioVeiculoController {
	
	@Autowired
	private FuncionarioVeiculoRepository funcionarioVeiculoRepository ;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@PostMapping("/novaSaida")
	public FuncionarioVeiculo novaSaida(Funcionario funcionario, Veiculo veiculo) {
		
		Optional<Funcionario> funcionarioExiste = funcionarioRepository.findById(funcionario.getId());
		Optional<Veiculo> veiculoExiste = veiculoRepository.findById(veiculo.getId());
		
		if(funcionarioExiste.get().getHabilitaçãoFuncionario().contains(veiculoExiste.get().getHabilitacaoDoVeiculo())) {
			FuncionarioVeiculo novo = new FuncionarioVeiculo(funcionario, veiculo);
			String data = String.format("%s", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
			novo.setDataSaida(data);
			funcionarioVeiculoRepository.save(novo);
			return novo;
			
		} else {
			return null;
		}
		
		
		
		
	}
	
	@PutMapping("/novaChegada")
	public FuncionarioVeiculo novaChegada(FuncionarioVeiculo funcionarioVeiculo, @RequestParam double quilomentragem ) {
		
		Optional<FuncionarioVeiculo> funcionarioVeiculoExiste = funcionarioVeiculoRepository.findById(funcionarioVeiculo.getId());
		
		if(funcionarioVeiculoExiste.isPresent()) {
			
			if(funcionarioVeiculo.getFuncionario() == null) {
				funcionarioVeiculo.setFuncionario(funcionarioVeiculoExiste.get().getFuncionario());
			}
			
			if(funcionarioVeiculo.getVeiculo() == null) {
				funcionarioVeiculo.setVeiculo(funcionarioVeiculoExiste.get().getVeiculo());
			}
			
			if(funcionarioVeiculo.getDataSaida() == null) {
				funcionarioVeiculo.setDataSaida(funcionarioVeiculoExiste.get().getDataSaida());
			}
			
			if(funcionarioVeiculoExiste.get().getVeiculo().getQuilometragemDoVeiculo() >= quilomentragem) {
				return null;
			} else {
				funcionarioVeiculo.getVeiculo().setQuilometragemDoVeiculo(quilomentragem);
			}
			
			String data = String.format("%s", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
			funcionarioVeiculo.setDataChegada(data);
			funcionarioVeiculoRepository.save(funcionarioVeiculo);
			
			return funcionarioVeiculo;
			
		} else {
			return null;
		}
	}
	 

}
