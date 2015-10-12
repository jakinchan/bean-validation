package sample.bean_validation.bean;

import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;

public class BuiltinAnnotationBean {
    @Digits(integer = 2, fraction = 3)
    private double d = 11.111;
    @Future
    private Date date = new Date();
}
