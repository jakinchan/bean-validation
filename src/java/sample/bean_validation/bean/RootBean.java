package sample.bean_validation.bean;

import javax.validation.Valid;

public class RootBean {
    
    @Valid
    private LeafBean leaf = new LeafBean();
}
