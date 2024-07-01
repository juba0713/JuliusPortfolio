package portfolio.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import portfolio.annotations.impl.NotEmptyImpl;

@Documented
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyImpl.class)
public @interface NotEmpty {

  String message() default "Cannot be empty.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
