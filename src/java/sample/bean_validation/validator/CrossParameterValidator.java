package sample.bean_validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import sample.bean_validation.constraint.CrossParameterValidation;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CrossParameterValidator implements ConstraintValidator<CrossParameterValidation, Object[]>{

    @Override
    public void initialize(CrossParameterValidation annotation) {}

    @Override
    public boolean isValid(Object[] args, ConstraintValidatorContext context) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Illegal method signature");
        }
        
        if (args[0] == null || args[1] == null) {
            return true;
        }
        
        int a = (int)args[0];
        int b = (int)args[1];
        
        return a < b;
    }
}
