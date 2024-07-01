package portfolio.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import portfolio.annotations.NotEmpty;

public class NotEmptyImpl implements ConstraintValidator<NotEmpty, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// Logging for debugging purposes
        if (value == null || value.isEmpty()) {
            return false;
        }
        
        return true;
	}
}
