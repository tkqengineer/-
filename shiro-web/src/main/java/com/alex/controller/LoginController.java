package com.alex.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alex on 2017/5/30.
 */
@Controller
public class LoginController {

    /**
     * 登陆方法
     *
     * @return
     */

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 退出方法可有可无
     *
     * @return
     */

    @RequestMapping("/logout")
    public String logout() {

        return "success";
    }

    /*
    *
    * 验证权限的测试方法
    *
    * */

    @RequestMapping("/permission")
    @RequiresPermissions("create:user:add")
    public String testPermission() {
        return "permission";
    }


}
