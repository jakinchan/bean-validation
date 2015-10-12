package sample.bean_validation.bean;

import javax.validation.constraints.NotNull;

public class ResourceBundleMessageBean {
    
    @NotNull(message="{sample.bean_validation.notNull}")
    private String value;
}
