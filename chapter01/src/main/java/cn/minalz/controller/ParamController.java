package cn.minalz.controller;

import cn.minalz.req.AddReq;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 参数控制器
 * @author minalz
 */
@RestController
@RequestMapping("param")
@AllArgsConstructor
public class ParamController {

    @PostMapping("/test")
    public String paramTest(@Validated @RequestBody AddReq addReq) {
        return "param-test";
    }
}
