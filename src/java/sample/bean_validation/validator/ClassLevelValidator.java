package sample.bean_validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import sample.bean_validation.bean.ClassLevelValidationBean;
import sample.bean_validation.constraint.ClassLevelValidation;

public class ClassLevelValidator implements ConstraintValidator<ClassLevelValidation, ClassLevelValidationBean>{

    @Override
    public void initialize(ClassLevelValidation annotation) {}

    @Override
    public boolean isValid(ClassLevelValidationBean bean, ConstraintValidatorContext context) {
        if (bean == null) {
            return true;
        }
        
        if (bean.isBool()) {
            if (bean.getString() == null) {
                this.rebuildConstraintViolation(context, "bool が true の場合、 string に null は指定できません。");
                return false;
            } else if (bean.getNumber() < 10) {
                this.rebuildConstraintViolation(context, "bool が true の場合、 number は 10 未満でなければなりません。");
                return false;
            }
        } else {
            if (bean.getString() != null) {
                this.rebuildConstraintViolation(context, "bool が false の場合、 string は null でなければなりません。");
                return false;
            } else if (10 <= bean.getNumber()) {
                this.rebuildConstraintViolation(context, "bool が false の場合、 number は 10 以上でなければなりません。");
                return false;
            }
        }
        
        return true;
    }
    
    private void rebuildConstraintViolation(ConstraintValidatorContext context, String template) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(template).addConstraintViolation();
    }
}
