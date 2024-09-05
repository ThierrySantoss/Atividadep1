package com.programacao1.atividade.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programacao1.atividade.model.entities.FuncionarioVeiculo;

public interface FuncionarioVeiculoRepository extends JpaRepository<FuncionarioVeiculo, Integer> {

}
