package com.yx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 20:58 2018/8/23
 * @ Description：${description}
 * @ Modified By：
 */
@Controller
public class NewCusController {
    @RequestMapping("/newCus")
            public String newCus(){
//        System.out.println("进入Controller");
            return "newCus";
}
}