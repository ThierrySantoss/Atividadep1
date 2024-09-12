package com.programacao1.atividade.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidadorLogica implements ConstraintValidator<PlacaValidador, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.trim() == "") {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Placa não pode ser nula!").addConstraintViolation();
			return false;
		}

		String regex = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);

		if (!matcher.matches()) {
			regex = "^([A-Z]{3})([0-9]{4})$";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(value);

			if (!matcher.matches()) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
						"Placa Invalida! Placa merco sul: AAA1A11, placa antiga: AAA1111").addConstraintViolation();
				return false;
			}

			return true;
		}

		return true;
	}
}
