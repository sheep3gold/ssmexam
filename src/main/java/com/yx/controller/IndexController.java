package com.yx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.bean.Customer;
import com.yx.dto.Msg;
import com.yx.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 10:41 2018/8/23
 * @ Description：${description}
 * @ Modified By：
 */
@Controller
public class IndexController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/index")
    public String index(){
//        System.out.println("进入Controller");
        return "index";
    }
    /**
     * 导入jackson包。
     * @param pn
     * @return
     */
    @RequestMapping("/cus")
    @ResponseBody
    public Msg getCusWithJson(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 10);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Customer> emps = customerService.getAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        return Msg.success().add("pageInfo", page);
    }
}