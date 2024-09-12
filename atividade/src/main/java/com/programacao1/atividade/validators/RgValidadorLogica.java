package com.programacao1.atividade.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RgValidadorLogica implements ConstraintValidator<RgValidador, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		String regex = "\\d{9}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
