package sample.bean_validation.bean;

import sample.bean_validation.constraint.CrossParameterValidation;

public class CrossParameterValidationBean {
    
    @CrossParameterValidation
    public void method(int a, int b) {
    }
}
