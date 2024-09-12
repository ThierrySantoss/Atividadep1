package com.programacao1.atividade.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.programacao1.atividade.model.entities.funcionario.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	@Query(value = "select * from funcionarios where DATEPART(MONTH, data_nascimento) = :mes and (data_penalizacao is null or data_penalizacao < GETDATE());", nativeQuery = true)
	public Iterable<Funcionario> obterFuncionariosMesPenalizacao(@Param("mes") int mes);

	@Query(value = "select * from funcionarios where data_penalizacao > GETDATE();", nativeQuery = true)
	public Iterable<Funcionario> obterFuncionarioPenalizacao();
}
