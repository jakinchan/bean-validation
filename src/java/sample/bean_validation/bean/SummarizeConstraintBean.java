package sample.bean_validation.bean;

import sample.bean_validation.constraint.SummarizeConstraint;

public class SummarizeConstraintBean {
    @SummarizeConstraint
    private int number;
    
    public SummarizeConstraintBean(int number) {
        this.number = number;
    }
}
