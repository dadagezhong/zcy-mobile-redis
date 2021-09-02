package com.zcy.mobile.controller;

import com.zcy.mobile.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis控制器
 * @author zhongchengye
 * @create 2021-09-02 14:31
 */
@RestController
public class RedisController {

    @Autowired
    RedisUtils redisUtils;

    @RequestMapping("/setAndGet")
    public String test(String key,String value){
        redisUtils.set(key,value);
        return redisUtils.get(key).toString();
    }
}
