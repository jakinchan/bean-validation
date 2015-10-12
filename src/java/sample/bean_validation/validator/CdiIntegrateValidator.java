package sample.bean_validation.validator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import sample.bean_validation.bean.cdi.Hoge;
import sample.bean_validation.constraint.CdiIntegrateValidation;

public class CdiIntegrateValidator implements ConstraintValidator<CdiIntegrateValidation, String>{
    
    @Inject
    private Hoge hoge;
    
    @Override
    public void initialize(CdiIntegrateValidation constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        this.hoge.method();
        return true;
    }
}
