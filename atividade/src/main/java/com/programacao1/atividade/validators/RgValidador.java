package com.programacao1.atividade.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = RgValidadorLogica.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RgValidador {

	String message() default "Rg invalido!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
