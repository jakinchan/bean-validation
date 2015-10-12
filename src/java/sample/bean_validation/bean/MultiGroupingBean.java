package sample.bean_validation.bean;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import sample.bean_validation.bean.group.HogeGroup;

public class MultiGroupingBean {
    @NotNull
    public String getString() {
        System.out.println("getString()");
        return null;
    }
    
    @Max(value=30, groups=HogeGroup.class)
    public int getNumber() {
        System.out.println("getNumber()");
        return 31;
    }
    
    @AssertTrue(groups={Default.class, HogeGroup.class})
    public boolean isBool() {
        System.out.println("isBool()");
        return false;
    }
}
