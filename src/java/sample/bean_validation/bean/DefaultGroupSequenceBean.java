package sample.bean_validation.bean;

import javax.validation.GroupSequence;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import sample.bean_validation.bean.group.HogeGroup;

@GroupSequence({HogeGroup.class, DefaultGroupSequenceBean.class})
public class DefaultGroupSequenceBean {
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
