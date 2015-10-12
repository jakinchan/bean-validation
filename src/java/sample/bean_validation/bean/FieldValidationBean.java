package sample.bean_validation.bean;

import javax.validation.constraints.NotNull;

public class FieldValidationBean {
    @NotNull
    private String value;

    public String getValue() {
        System.out.println("FieldValidationBean#getValue()");
        return value;
    }
}
