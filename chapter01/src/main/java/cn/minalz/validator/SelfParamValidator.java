package cn.minalz.validator;

import cn.minalz.annotation.SelfParamCheck;
import cn.minalz.req.AddReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 自定义校验
 * @author minalz
 */
public class SelfParamValidator implements ConstraintValidator<SelfParamCheck, AddReq> {
    @Override
    public void initialize(SelfParamCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AddReq addReq, ConstraintValidatorContext constraintValidatorContext) {
        List<String> msgList = new ArrayList<>();
        String code = addReq.getCode();
        if (StringUtils.isEmpty(code)) {
            msgList.add("编码");
        }
        if (StringUtils.isEmpty(addReq.getUsername())) {
            msgList.add("用户名");
        }
        if (StringUtils.isEmpty(addReq.getPhone())) {
            msgList.add("手机号");
        }
        // 宠物健康校验
        if (Objects.equals("1", code)) {
            if (StringUtils.isEmpty(addReq.getEmail())) {
                msgList.add("邮箱地址");
            }
        } else {
            if (StringUtils.isEmpty(addReq.getAddress())) {
                msgList.add("地址");
            }
        }

        if (CollectionUtils.isEmpty(msgList)) {
            return true;
        }

        String msg = StringUtils.join(msgList, ",") + "不能为空";

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
        return false;
    }
}
