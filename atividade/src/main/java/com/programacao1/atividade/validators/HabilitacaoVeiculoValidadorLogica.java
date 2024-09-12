package com.programacao1.atividade.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.programacao1.atividade.model.entities.veiculo.Habilitacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HabilitacaoVeiculoValidadorLogica
		implements ConstraintValidator<HabilitacaoVeiculoValidador, Habilitacao> {

	@Override
	public boolean isValid(Habilitacao value, ConstraintValidatorContext context) {

		if (value == null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Categoria não pode ser null").addConstraintViolation();
			return false;
		}

		String regex = "^[A-E]$";
		Pattern pattern = Pattern.compile(regex);
		String codigo = value.getCodigo();
		Matcher matcher = pattern.matcher(codigo);

		return matcher.matches();

	}
}
