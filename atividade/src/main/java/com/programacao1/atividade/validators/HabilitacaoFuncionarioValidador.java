package com.programacao1.atividade.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = HabilitacaoFuncionarioValidadorLogica.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface HabilitacaoFuncionarioValidador {

	String message() default "Habilitação Invalida!, Separar Categorias com ',': A,B";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
