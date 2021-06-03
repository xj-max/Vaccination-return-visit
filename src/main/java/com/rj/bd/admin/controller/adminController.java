package com.rj.bd.admin.controller;

import com.rj.bd.admin.entity.Admin;
import com.rj.bd.admin.service.IAdminervice;
import com.rj.bd.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wxy
 * @desc admin控制层
 * @time 2021-06-01-9:57
 */
@RestController
@RequestMapping("/admin")
public class adminController {
    @Autowired
    private IAdminervice adminervice;

    /**
     * @param adminname
     * @param adminpwd
     * @return 登录成功的json
     * @desc 通过手机号+验证码进行登录
     */
    @RequestMapping("/login")
    @CrossOrigin
    public Map<String, Object> adminLogin(String adminname, String adminpwd) {
        //手机号+验证码进行登录
        List<Admin> list = adminervice.adminLogin(adminname, adminpwd);
        //非空判断
        if (list.isEmpty()) {
            return JsonUtils.toJson("登录失败,请检查您管理员账号与密码。", 1);
        }
        //返回json
        return JsonUtils.toJson("登录成功", 1);
    }


}
