package com.programacao1.atividade.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.programacao1.atividade.model.entities.veiculo.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, String> {

}
