package sample.bean_validation.bean;

import sample.bean_validation.constraint.CustomReturnValueValidation;

public class CustomReturnValueValidationBean {
    
    @CustomReturnValueValidation
    public String method(int i) {
        return "fuga";
    }
}
