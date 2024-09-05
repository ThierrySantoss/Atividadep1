package com.programacao1.atividade.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programacao1.atividade.model.entities.veiculo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

}
