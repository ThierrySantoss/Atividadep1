package com.programacao1.atividade.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programacao1.atividade.model.entities.funcionario.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
