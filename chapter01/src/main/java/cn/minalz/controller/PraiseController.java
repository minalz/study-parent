package cn.minalz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 点赞控制器
 * @author minalz
 */
@RestController
public class PraiseController {

    @RequestMapping("/test")
    public String praiseTest() {
        return "praise-test";
    }
}
