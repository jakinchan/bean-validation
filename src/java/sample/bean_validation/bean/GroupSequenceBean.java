package sample.bean_validation.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import sample.bean_validation.bean.group.HogeGroup;

public class GroupSequenceBean {
    @NotNull
    public String getString() {
        System.out.println("getString()");
        return null;
    }
    
    @Max(value=30, groups=HogeGroup.class)
    public int getNumber() {
        System.out.println("getNumber()");
        return 29;
    }
}
