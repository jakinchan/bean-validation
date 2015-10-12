package sample.bean_validation.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import sample.bean_validation.entity.Sample;

@Stateless
public class JpaIntegrationEjb {
    @PersistenceContext(unitName="sample")
    private EntityManager em;
    
    public void execute() {
        Sample sample = new Sample();
        try {
            this.em.persist(sample);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            e.getConstraintViolations().forEach(cv -> System.out.println("message = " + cv.getMessage()));
        }
    }
}
