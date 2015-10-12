package sample.bean_validation.bean;

import javax.validation.constraints.NotNull;

public class MethodReturnValueValidationBean {
    
    @NotNull
    public String method() {
        return null;
    }
}
