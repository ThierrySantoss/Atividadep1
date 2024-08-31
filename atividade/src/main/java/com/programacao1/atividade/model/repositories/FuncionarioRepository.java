package com.programacao1.atividade.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.programacao1.atividade.model.entities.funcionario.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

}
