package sample.bean_validation.bean;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import sample.bean_validation.bean.group.HogeGroup;

public class GroupingBean {
    @NotNull
    private String string;
    
    @Max(30)
    private int integer = 31;
    
    @AssertTrue(groups=HogeGroup.class)
    private boolean bool;
    
    @DecimalMin(value="19.9", groups=HogeGroup.class)
    private double decimal = 19.8;
}
