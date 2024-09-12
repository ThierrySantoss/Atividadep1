package com.programacao1.atividade.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.programacao1.atividade.model.entities.veiculo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

	@Query(value = "SELECT * FROM veiculos WHERE chave LIKE %:ano%", nativeQuery = true)
	public Iterable<Veiculo> obterCarrosDeUmAno(@Param("ano") String ano);

	@Query(value = "Select * FROM veiculos WHERE modelo_veiculo = :modelo", nativeQuery = true)
	public Iterable<Veiculo> obterCarrosPorModelo(@Param("modelo") String modelo);

	@Query(value = "Select * From veiculos order by quilometragem_do_veiculo desc", nativeQuery = true)
	public Page<Veiculo> obterCarrosComMaiorKm(Pageable pageable);

}
