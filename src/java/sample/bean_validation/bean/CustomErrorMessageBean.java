package sample.bean_validation.bean;

import javax.validation.constraints.NotNull;

public class CustomErrorMessageBean {

    @NotNull(message="null はダメ！")
    private String value;
}
