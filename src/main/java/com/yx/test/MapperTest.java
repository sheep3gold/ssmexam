package com.yx.test;

import com.yx.bean.Customer;
import com.yx.dao.CustomerMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ Author     ：yx
 * @ Date       ：Created in 18:45 2018/8/23
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    CustomerMapper customerMapper;


    @Autowired
    SqlSession sqlSession;

    /**
     * 获取所有部门
     */
    @Test
    public void text01() {
        System.out.println("所有部门 " + customerMapper.selectByExample(null));
    }
}