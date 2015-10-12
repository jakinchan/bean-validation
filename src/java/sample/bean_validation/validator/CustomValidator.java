package sample.bean_validation.validator;

import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import sample.bean_validation.constraint.CustomValidation;

public class CustomValidator implements ConstraintValidator<CustomValidation, String>{
    
    private String value;
    
    @Override
    public void initialize(CustomValidation annotation) {
        System.out.println("initialize() : " + hashCode());
        this.value = annotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("isValid() : " + hashCode());
        if (value == null) {
            return true;
        }
        
        return Objects.equals(this.value, value);
    }
}
