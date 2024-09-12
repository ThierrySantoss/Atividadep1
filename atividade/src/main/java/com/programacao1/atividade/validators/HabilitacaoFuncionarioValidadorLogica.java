package com.programacao1.atividade.validators;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.programacao1.atividade.model.entities.veiculo.Habilitacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HabilitacaoFuncionarioValidadorLogica
		implements ConstraintValidator<HabilitacaoFuncionarioValidador, List<Habilitacao>> {

	@Override
	public boolean isValid(List<Habilitacao> value, ConstraintValidatorContext context) {

		String regex = "^[A-E]$";
		Pattern pattern = Pattern.compile(regex);

		for (Habilitacao habilitacao : value) {
			String codigo = habilitacao.getCodigo();
			Matcher matcher = pattern.matcher(codigo);

			if (codigo == null || !matcher.matches()) {
				return false;
			}

		}
		return true;

	}

}
