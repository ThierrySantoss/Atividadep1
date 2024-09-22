package com.programacao1.atividade.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.programacao1.atividade.model.entities.FuncionarioVeiculo;
import com.programacao1.atividade.model.entities.FuncionarioVeiculoDTO;

public interface FuncionarioVeiculoRepository extends JpaRepository<FuncionarioVeiculo, Integer> {

	@Query("SELECT new com.programacao1.atividade.model.entities.FuncionarioVeiculoDTO (f.nome, COUNT(fv)) \r\n"
			+ "FROM FuncionarioVeiculo fv \r\n" + "JOIN fv.funcionario f \r\n" + "GROUP BY f.nome \r\n"
			+ "ORDER BY COUNT(fv) DESC")
	public Page<FuncionarioVeiculoDTO> maisPegouCarro(Pageable pageable);

}
