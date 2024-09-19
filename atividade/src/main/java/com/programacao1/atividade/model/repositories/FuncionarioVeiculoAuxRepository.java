package com.programacao1.atividade.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.programacao1.atividade.model.entities.FuncionarioVeiculoAux;

public interface FuncionarioVeiculoAuxRepository extends JpaRepository<FuncionarioVeiculoAux, Integer> {
	
	@Query(value = "select * from funcionario_veiculo_aux", nativeQuery = true)
	public Page<FuncionarioVeiculoAux> obterMotoristasqueMaisDirigiram(Pageable pageable);

	@Modifying
	@Query(value = "insert into funcionario_veiculo_aux (id, nome, total)\r\n"
			+ "select fv.funcionario_id, f.nome, COUNT(*) AS Total\r\n" + "from funcionario_veiculo fv\r\n"
			+ "INNER JOIN funcionarios f ON f.id = fv.funcionario_id\r\n"
			+ "group by fv.funcionario_id, f.nome", nativeQuery = true)
	void atualizarTabela();

}
