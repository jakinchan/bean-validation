package sample.bean_validation.bean;

import javax.validation.constraints.NotNull;

public class MethodParameterValidationBean {
    
    public void method(@NotNull String value) {
    }
}
