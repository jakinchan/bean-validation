package sample.bean_validation.bean;

import javax.validation.Valid;

public class FooBean {
    @Valid
    private BarBean bar = new BarBean();
}
