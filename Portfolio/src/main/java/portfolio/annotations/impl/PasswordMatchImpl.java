package portfolio.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import portfolio.annotations.PasswordMatch;
import portfolio.controllers.function.customvalidation.InputWebDto;

public class PasswordMatchImpl implements ConstraintValidator<PasswordMatch, InputWebDto>{

	@Override
	public boolean isValid(InputWebDto webDto, ConstraintValidatorContext context) {
		
		if(!webDto.getPassword().equals(webDto.getConfirmPassword())) {
			return false;
		}
		
		return true;
	}

}
