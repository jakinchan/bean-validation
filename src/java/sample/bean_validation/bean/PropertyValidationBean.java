package sample.bean_validation.bean;

import javax.validation.constraints.NotNull;

public class PropertyValidationBean {
    
    private String value = "xxx";

    @NotNull
    public String getValue() {
        System.out.println("PropertyValidationBean.getValue()");
        return null;
    }
}
