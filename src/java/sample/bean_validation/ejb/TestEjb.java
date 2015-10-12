package sample.bean_validation.ejb;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;
import sample.bean_validation.bean.BarListBean;
import sample.bean_validation.bean.BuiltinAnnotationBean;
import sample.bean_validation.bean.ClassLevelValidationBean;
import sample.bean_validation.bean.ConvertGroupBean;
import sample.bean_validation.bean.CrossParameterValidationBean;
import sample.bean_validation.bean.CustomErrorMessageBean;
import sample.bean_validation.bean.CustomReturnValueValidationBean;
import sample.bean_validation.bean.CustomValidationBean;
import sample.bean_validation.bean.DefaultGroupSequenceBean;
import sample.bean_validation.bean.ELExpressionMessageBean;
import sample.bean_validation.bean.ELFormatterMessageBean;
import sample.bean_validation.bean.FieldValidationBean;
import sample.bean_validation.bean.FooBean;
import sample.bean_validation.bean.GroupSequenceBean;
import sample.bean_validation.bean.GroupingBean;
import sample.bean_validation.bean.MethodParameterValidationBean;
import sample.bean_validation.bean.MethodReturnValueValidationBean;
import sample.bean_validation.bean.MultiConstraintFieldBean;
import sample.bean_validation.bean.MultiGroupingBean;
import sample.bean_validation.bean.OverrideDefaultMessageBean;
import sample.bean_validation.bean.PropertyValidationBean;
import sample.bean_validation.bean.ReferenceAnnotationAttributeBean;
import sample.bean_validation.bean.ResourceBundleMessageBean;
import sample.bean_validation.bean.RootBean;
import sample.bean_validation.bean.SummarizeConstraintBean;
import sample.bean_validation.bean.group.HogeDefault;
import sample.bean_validation.bean.group.DefaultHoge;
import sample.bean_validation.bean.group.HogeGroup;

@Stateless
public class TestEjb {
    
    public void builtinAnnotation() {
        BuiltinAnnotationBean bean = new BuiltinAnnotationBean();
        
        this.validate(bean);
    }
    
    public void customReturnValueValidation() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ExecutableValidator validator = factory.getValidator().forExecutables();
        
        CustomReturnValueValidationBean bean = new CustomReturnValueValidationBean();
        Method method = CustomReturnValueValidationBean.class.getMethod("method", int.class);
        
        String result = bean.method(1);
        
        Set<ConstraintViolation<CustomReturnValueValidationBean>> constraintViolations
                = validator.validateReturnValue(bean, method, result);
        
        this.showConstraintViolation(constraintViolations);
    }
    
    public void crossParameterValidation() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ExecutableValidator validator = factory.getValidator().forExecutables();
        
        CrossParameterValidationBean bean = new CrossParameterValidationBean();
        Method method = CrossParameterValidationBean.class.getMethod("method", int.class, int.class);
        
        Object[] parameters = {20, 10};
        
        Set<ConstraintViolation<CrossParameterValidationBean>> constraintViolations
                = validator.validateParameters(bean, method, parameters);
        
        this.showConstraintViolation(constraintViolations);
    }
    
    public void methodReturnValueValidation() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ExecutableValidator validator = factory.getValidator().forExecutables();
        
        MethodReturnValueValidationBean bean = new MethodReturnValueValidationBean();
        Method method = MethodReturnValueValidationBean.class.getMethod("method");
        
        Object returnValue = bean.method();
        
        Set<ConstraintViolation<MethodReturnValueValidationBean>> constraintViolations
                = validator.validateReturnValue(bean, method, returnValue);
        
        this.showConstraintViolation(constraintViolations);
    }
    
    public void methodParameterValidation() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ExecutableValidator validator = factory.getValidator().forExecutables();
        
        MethodParameterValidationBean bean = new MethodParameterValidationBean();
        Method method = MethodParameterValidationBean.class.getMethod("method", String.class);
        
        Object[] parameters = {null};
        
        Set<ConstraintViolation<MethodParameterValidationBean>> constraintViolations
                = validator.validateParameters(bean, method, parameters);
        
        this.showConstraintViolation(constraintViolations);
    }
    
    public void classLevelValidation() {
        ClassLevelValidationBean bean = new ClassLevelValidationBean(true, null, 5);
        this.validate(bean);
        
        bean = new ClassLevelValidationBean(false, null, 15);
        this.validate(bean);
    }
    
    public void customValidation() {
        CustomValidationBean bean = new CustomValidationBean();
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        this.validate(validator, bean);
        this.validate(validator, bean);
        this.validate(validator, bean);
    }
    
    public void summarizeConstraint() {
        SummarizeConstraintBean bean = new SummarizeConstraintBean(5);
        
        this.validate(bean);
        
        bean = new SummarizeConstraintBean(35);
        
        this.validate(bean);
    }
    
    public void multiConstraintField() {
        MultiConstraintFieldBean bean = new MultiConstraintFieldBean(35);
        
        this.validate(bean);
        this.validate(bean, HogeGroup.class);
    }
    
    public void convertGroup() {
        ConvertGroupBean bean = new ConvertGroupBean();
        
        this.validate(bean);
    }
    
    public void defaultGroupSequence() {
        DefaultGroupSequenceBean bean = new DefaultGroupSequenceBean();
        
        this.validate(bean);
    }
    
    public void groupSequence() {
        GroupSequenceBean bean = new GroupSequenceBean();
        
        this.validate(bean, DefaultHoge.class);
        this.validate(bean, HogeDefault.class);
    }
    
    public void multiGrouping() {
        MultiGroupingBean bean = new MultiGroupingBean();
        
        this.validate(bean, HogeGroup.class);
        this.validate(bean, HogeGroup.class, Default.class);
    }
    
    public void grouping() {
        GroupingBean bean = new GroupingBean();
        
        this.validate(bean);
        this.validate(bean, HogeGroup.class);
        this.validate(bean, Default.class);
    }
    
    public void elFormatterMessage() {
        ELFormatterMessageBean bean = new ELFormatterMessageBean();
        
        this.validate(bean);
    }
    
    public void elExpressionMessage() {
        ELExpressionMessageBean bean = new ELExpressionMessageBean();
        
        this.validate(bean);
    }
    
    public void referenceAnnotationAttribute() {
        ReferenceAnnotationAttributeBean bean = new ReferenceAnnotationAttributeBean();
        
        this.validate(bean);
    }
    
    public void overrideDefaultMessage() {
        OverrideDefaultMessageBean bean = new OverrideDefaultMessageBean();
        
        this.validate(bean);
    }
    
    public void resourceBundleMessage() {
        ResourceBundleMessageBean bean = new ResourceBundleMessageBean();
        
        this.validate(bean);
    }
    
    public void customErrorMessage() {
        CustomErrorMessageBean bean = new CustomErrorMessageBean();
        
        this.validate(bean);
    }
    
    public void constraintVioletion() {
        RootBean root = new RootBean();
        
        this.debugValidate(root);
    }
    
    public void listField() {
        BarListBean bean = new BarListBean();
        
        this.validate(bean);
    }
    
    public void objectGraph() {
        FooBean foo = new FooBean();
        
        this.validate(foo);
    }
    
    
    public void propertyValidation() {
        PropertyValidationBean bean = new PropertyValidationBean();
        
        this.validate(bean);
    }
    
    public void fieldValidation() {
        FieldValidationBean bean = new FieldValidationBean();
        
        this.validate(bean);
    }
    
    private <T> void validate(T bean) {
        this.validate(bean, new Class<?>[0]);
    }
    
    private <T> void validate(T bean, Class<?>... groups) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        this.validate(validator, bean, groups);
    }
    
    private <T> void validate(Validator validator, T bean, Class<?>... groups) {
        if (groups.length == 0) {
            System.out.println("[no group]");
        } else {
            System.out.println("[group=" + Arrays.toString(groups) + "]");
        }
        
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean, groups);
        this.showConstraintViolation(constraintViolations);
    }
    
    private <T> void showConstraintViolation(Set<ConstraintViolation<T>> constraintViolations) {
        System.out.println("size = " + constraintViolations.size());
        
        constraintViolations.forEach(constraintViolation -> {
            System.out.println("message = " + constraintViolation.getMessage());
        });
    }
    
    private <T> void debugValidate(T bean) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
        
        System.out.println("size = " + constraintViolations.size());
        
        constraintViolations.forEach(constraintViolation -> {
            String msg =
                "message = " + constraintViolation.getMessage() + "\n" +
                "messageTemplate = " + constraintViolation.getMessageTemplate() + "\n" +
                "rootBean = " + constraintViolation.getRootBean() + "\n" +
                "rootBeanClass = " + constraintViolation.getRootBeanClass() + "\n" +
                "invalidValue = " + constraintViolation.getInvalidValue() + "\n" +
                "propertyPath = " + constraintViolation.getPropertyPath() + "\n" +
                "leafBean = " + constraintViolation.getLeafBean() + "\n" +
                "descriptor = " + constraintViolation.getConstraintDescriptor() + "\n"
            ;
            
            System.out.println(msg);
        });
    }
}
