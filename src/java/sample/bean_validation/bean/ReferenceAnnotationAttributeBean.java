package sample.bean_validation.bean;

import javax.validation.constraints.Max;

public class ReferenceAnnotationAttributeBean {
    @Max(value=50, message="{value} 以下じゃないとダメです")
    private int number = 51;
}
