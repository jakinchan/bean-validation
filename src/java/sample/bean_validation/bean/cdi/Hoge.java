package sample.bean_validation.bean.cdi;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Hoge {
    
    public void method() {
        System.out.println("Hoge.method()");
    }
}
