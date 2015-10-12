package sample.bean_validation.ejb;

import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import sample.bean_validation.bean.cdi.CdiBean;
import sample.bean_validation.bean.cdi.CdiIntegrateValidationBean;

@Stateless
public class CdiIntegrationEjb {
    @Inject
    private Validator validator;
    @Inject
    private CdiBean bean;
    
    public void execute() {
        Set<ConstraintViolation<CdiBean>> constraintViolations = this.validator.validate(this.bean);
        System.out.println("size = " + constraintViolations.size());
        constraintViolations.forEach(cv -> System.out.println("message = " + cv.getMessage()));
        
        this.invoke(() -> this.bean.setValue(null));
        this.invoke(this.bean::method);
    }
    
    public void validator() {
        CdiIntegrateValidationBean bean = new CdiIntegrateValidationBean();
        this.validator.validate(bean);
    }
    
    private void invoke(Runnable runnable) {
        try {
            runnable.run();
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
        }
    }
}
