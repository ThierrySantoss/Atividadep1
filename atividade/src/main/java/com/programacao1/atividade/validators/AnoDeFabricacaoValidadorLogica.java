package com.programacao1.atividade.validators;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnoDeFabricacaoValidadorLogica implements ConstraintValidator<AnoDeFabricacaoValidador, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value == null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Data não pode ser nulo").addConstraintViolation();
			return false;
		}

		String valueString = value.toString();
		String regex = "\\d{4}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(valueString);

		if (value > LocalDate.now().getYear() || value < 1900) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Data não pode ser no futuro ou menor que 1900!")
					.addConstraintViolation();
			return false;
		} else if (!matcher.matches()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Data Invalida").addConstraintViolation();

			return false;
		}

		return true;
	}

}
