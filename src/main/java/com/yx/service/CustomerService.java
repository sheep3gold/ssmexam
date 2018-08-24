package com.yx.service;

import com.yx.bean.Customer;
import com.yx.bean.CustomerExample;
import com.yx.dao.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 19:14 2018/8/23
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    /**
     * 查询所有员工
     * @return
     */
    public List<Customer> getAll() {
        // TODO Auto-generated method stub
        return customerMapper.selectByExample(null);
    }
    /**
     * @author  yx
     * @create  2018/8/23 21:14
     * @desc 查询用户名密码是否存在
     **/
    public boolean checkUser(String firstname,String password){
        CustomerExample example = new CustomerExample();
        //这个我相信学过Hibernate 的同学都知道这个用法 不难 你可以理解为在where 加入条件
        CustomerExample.Criteria criteria = example.createCriteria();
        //andEmpNameEqualTo根据词意来理解这个相当于 传入的这个empName与数据库的empName进行对比 不存在返回 0 ，存在返回其他
        criteria.andFirstNameEqualTo(firstname);
        criteria.andLastNameEqualTo(password);
        long count = customerMapper.countByExample(example);
        return count != 0;
    }
}
