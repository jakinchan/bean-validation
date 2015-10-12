package sample.bean_validation.bean;

import javax.validation.constraints.Null;

public class OverrideDefaultMessageBean {
    @Null
    private String value = "xxx";
}
