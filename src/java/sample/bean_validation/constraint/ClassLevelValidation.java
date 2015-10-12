package sample.bean_validation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import sample.bean_validation.validator.ClassLevelValidator;

@Constraint(validatedBy = ClassLevelValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassLevelValidation {
    
    String message() default "{sample.bean_validation.constraint.ClassLevelValidation.message}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
