package com.alex.controller;

import com.alex.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @classDesc: 功能描述:()
 * @author: 滕康全
 * @createTime: 2017/6/12 16:01:55
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Controller
public class KK {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String kk(){
        System.out.println(helloService.hello() + "0-------------------------");
        return "kkkkkk";
    }


}
