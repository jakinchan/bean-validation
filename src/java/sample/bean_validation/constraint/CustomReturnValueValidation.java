package sample.bean_validation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import sample.bean_validation.validator.CustomReturnValueValidator;

@Constraint(validatedBy = CustomReturnValueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomReturnValueValidation {
    
    String message() default "{sample.bean_validation.constraint.CustomReturnValueValidation.message}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
