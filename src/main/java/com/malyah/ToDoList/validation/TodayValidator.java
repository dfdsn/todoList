package com.malyah.ToDoList.validation;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TodayValidator implements ConstraintValidator<Today, LocalDateTime> {

	@Override
	public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
		 if (value == null) {
	            return false; // ou true, dependendo de sua lógica para nulo
	        }
	        return value.equals(LocalDate.now());
	    }

}
