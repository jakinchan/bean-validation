package sample.bean_validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import sample.bean_validation.constraint.CustomReturnValueValidation;

public class CustomReturnValueValidator implements ConstraintValidator<CustomReturnValueValidation, String> {

    @Override
    public void initialize(CustomReturnValueValidation constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        
        return "hoge".equals(value);
    }
}
