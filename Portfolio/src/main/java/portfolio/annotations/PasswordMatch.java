package portfolio.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import portfolio.annotations.impl.PasswordMatchImpl;

@Documented
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchImpl.class)
public @interface PasswordMatch {
	
	String message() default "Password doesn't match!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
