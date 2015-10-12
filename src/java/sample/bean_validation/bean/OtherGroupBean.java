package sample.bean_validation.bean;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import sample.bean_validation.bean.group.HogeGroup;

public class OtherGroupBean {
    @AssertTrue
    private boolean bool;
    
    @Min(value=10, groups=HogeGroup.class)
    private int number = 9;
}
