package sample.bean_validation.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import sample.bean_validation.bean.group.HogeGroup;

public class ConvertGroupBean {
    @NotNull
    private String string;
    @Valid @ConvertGroup(from=Default.class, to=HogeGroup.class)
    private OtherGroupBean other = new OtherGroupBean();
}
