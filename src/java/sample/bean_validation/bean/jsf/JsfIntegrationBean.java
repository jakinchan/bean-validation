package sample.bean_validation.bean.jsf;

import javax.enterprise.inject.Model;
import javax.validation.constraints.Pattern;

@Model
public class JsfIntegrationBean {
    @Pattern(regexp="[a-z]+")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public void method() {
        System.out.println("value=" + value);
    }
}
