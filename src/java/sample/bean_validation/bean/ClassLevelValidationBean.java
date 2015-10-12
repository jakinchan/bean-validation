package sample.bean_validation.bean;

import sample.bean_validation.constraint.ClassLevelValidation;

@ClassLevelValidation
public class ClassLevelValidationBean {

    private boolean bool;
    private String string;
    private int number;
    
    public ClassLevelValidationBean(boolean bool, String string, int number) {
        this.bool = bool;
        this.string = string;
        this.number = number;
    }

    public boolean isBool() {
        return bool;
    }

    public String getString() {
        return string;
    }

    public int getNumber() {
        return number;
    }
}
