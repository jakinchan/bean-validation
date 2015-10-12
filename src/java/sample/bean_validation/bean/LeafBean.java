package sample.bean_validation.bean;

import javax.validation.constraints.Min;

public class LeafBean {
    @Min(10)
    private int number = 9;
}
