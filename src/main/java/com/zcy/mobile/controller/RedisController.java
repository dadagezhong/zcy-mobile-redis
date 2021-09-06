package com.zcy.mobile.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zcy.mobile.pojo.NbaPlayer;
import com.zcy.mobile.service.NbaPlayerService;
import com.zcy.mobile.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Redis控制器
 * @author zhongchengye
 * @create 2021-09-02 14:31
 */
@RestController
public class RedisController {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    private NbaPlayerService nbaPlayerService;

    @RequestMapping("/setAndGet")
    public String test(String key,String value){
        redisUtils.set(key,value);
        return redisUtils.get(key).toString();
    }

    @RequestMapping("test")
    public Object test(){
        //step1 先从redis中取，redis空则从DB取值
        String strJson=(String) redisUtils.get("nbaPlayerCache");
        if (strJson==null){
            System.out.println("从db取值");
            // step2如果拿不到则从DB取值
            List<NbaPlayer> listNbaPlayer=nbaPlayerService.ListNbaPlayer();
            // step3 DB非空情况刷新redis值
            if (listNbaPlayer!=null){
                redisUtils.set("nbaPlayerCache", JSON.toJSONString(listNbaPlayer),20L);
                return listNbaPlayer;
            }
            return null;
        }else {
            System.out.println("从redis缓存取值");
            return JSONObject.parseArray(strJson,NbaPlayer.class);
        }
    }
}
