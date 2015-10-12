package sample.bean_validation.bean;

import javax.validation.constraints.Max;
import sample.bean_validation.bean.group.HogeGroup;

public class MultiConstraintFieldBean {
    @Max.List({
        @Max(30),
        @Max(value=40, groups=HogeGroup.class)
    })
    private int value;
    
    public MultiConstraintFieldBean(int value) {
        this.value = value;
    }
}
