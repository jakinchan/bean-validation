package sample.bean_validation.ejb;

import java.util.Set;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import sample.bean_validation.bean.HelloBean;

@Stateless
public class HelloEjb {
    
    public void hello() {
        // Validator を取得
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        // Bean を作成
        HelloBean bean = new HelloBean();
        
        // バリデーションを実行
        Set<ConstraintViolation<HelloBean>> result = validator.validate(bean);
        
        // 結果の確認
        System.out.println("size = " + result.size());
        System.out.println("message = " + result.iterator().next().getMessage());
    }
}

