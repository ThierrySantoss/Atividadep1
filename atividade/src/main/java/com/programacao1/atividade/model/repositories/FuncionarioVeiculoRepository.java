package com.programacao1.atividade.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.programacao1.atividade.model.entities.FuncionarioVeiculo;

public interface FuncionarioVeiculoRepository extends JpaRepository<FuncionarioVeiculo, Integer> {

	@Query(value = "select fv.funcionario_id, f.nome, COUNT(*) Total \r\n" + "from funcionario_veiculo fv \r\n"
			+ "	inner join funcionarios f on (f.id = fv.funcionario_id)\r\n"
			+ "group by funcionario_id, f.nome", nativeQuery = true)
	Page<Object[]> obterMotoristasqueMaisDirigiram(Pageable pageable);
	// TODO: perguntar ao professor sobre Page<Object[]>.

}
