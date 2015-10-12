package sample.bean_validation.bean;

import javax.validation.constraints.Max;

public class ELFormatterMessageBean {
    
    @Max(value=40, message="${formatter.format('%d 以下のみ可（実際=%d）', value, validatedValue)}")
    private int number = 49;
}
