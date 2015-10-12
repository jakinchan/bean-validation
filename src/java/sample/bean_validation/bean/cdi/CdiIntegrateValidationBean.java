package sample.bean_validation.bean.cdi;

import sample.bean_validation.constraint.CdiIntegrateValidation;

public class CdiIntegrateValidationBean {
    @CdiIntegrateValidation
    private String value;
}
