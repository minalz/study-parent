package cn.minalz.req;

import cn.minalz.annotation.SelfParamCheck;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 入参
 * @author minalz
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SelfParamCheck
public class AddReq {

    private String code;

    private String username;

    private String phone;

    private String address;

    private String email;
}
