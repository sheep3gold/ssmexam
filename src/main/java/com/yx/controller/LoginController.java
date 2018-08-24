package com.yx.controller;

import com.yx.dto.LoginMsg;
import com.yx.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 17:22 2018/8/23
 * @ Description：${description}
 * @ Modified By：
 */
@Controller
public class LoginController {
    @Autowired
    CustomerService customerService;
    @RequestMapping("/login")
    public String login(){
//        System.out.println("进入Controller");
        return "login";
    }
    @RequestMapping("/check")
    @ResponseBody
    public boolean checkUser(String firstname,String password){
        return customerService.checkUser(firstname,password);
    }
}
