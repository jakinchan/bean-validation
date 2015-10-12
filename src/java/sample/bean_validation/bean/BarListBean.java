package sample.bean_validation.bean;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;

public class BarListBean {
    @Valid
    private List<BarBean> barList = Arrays.asList(new BarBean(), new BarBean());
}
