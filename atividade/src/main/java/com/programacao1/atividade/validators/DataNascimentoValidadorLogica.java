package com.programacao1.atividade.validators;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DataNascimentoValidadorLogica implements ConstraintValidator<DataNascimentoValidador, LocalDate> {

	private static int anoAtual = LocalDate.now().getYear();

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

		if (value == null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Data não pode ser nulo!").addConstraintViolation();
			return false;
		} else if (value.getYear() < 1930) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Idade Invalida!").addConstraintViolation();
			return false;

		} else if ((anoAtual - value.getYear()) < 14) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Funcionario tem idade menor que 14 anos!")
					.addConstraintViolation();
			return false;
		}

		return true;

	}
}
