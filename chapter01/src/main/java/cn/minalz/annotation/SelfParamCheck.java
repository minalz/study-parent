package cn.minalz.annotation;

import cn.minalz.validator.SelfParamValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义校验注解
 * @author minalz
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SelfParamValidator.class )
public @interface SelfParamCheck {

    String message() default "字段校验异常";

    /**
     * 将validator进行分类，不同的类group中会执行不同的validator操作
     *
     * @return validator的分类类型
     */
    Class<?>[] groups() default {};
    /**
     * 主要是针对bean，很少使用
     *
     * @return 负载
     */
    Class<? extends Payload>[] payload() default {};
}
