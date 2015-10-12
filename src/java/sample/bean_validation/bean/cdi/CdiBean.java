package sample.bean_validation.bean.cdi;

import javax.enterprise.context.RequestScoped;
import javax.validation.constraints.NotNull;

@RequestScoped
public class CdiBean {
    @NotNull
    private String value;

    public void setValue(@NotNull String value) {
        this.value = value;
    }
    
    @NotNull
    public String method() {
        return this.value;
    }
}
