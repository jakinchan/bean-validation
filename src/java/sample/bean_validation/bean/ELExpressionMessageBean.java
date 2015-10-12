package sample.bean_validation.bean;

import javax.validation.constraints.Max;

public class ELExpressionMessageBean {
    
    @Max(value=30, message="${value} より ${validatedValue - value} も大きい値が渡された！")
    private int number = 42;
}
