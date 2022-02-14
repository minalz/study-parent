package cn.minalz.controller;

import cn.minalz.util.RedisUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 点赞控制器
 * @author minalz
 */
@RestController
@RequestMapping("praise")
@AllArgsConstructor
public class PraiseController {

    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public String praiseTest() {
//        redisUtil.set("test", 1);
        return "praise-test";
    }
}
