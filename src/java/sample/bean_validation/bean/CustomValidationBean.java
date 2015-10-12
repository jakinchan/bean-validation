package sample.bean_validation.bean;

import sample.bean_validation.constraint.CustomValidation;

public class CustomValidationBean {
    @CustomValidation("hoge")
    private String value = "Hoge";
}
