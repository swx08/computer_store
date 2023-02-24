package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName:UserMapperTests
 * Package:com.cy.store.mapper
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 17:25
 * @Version:v1.0
 */
@SpringBootTest//不会随同项目一起打包
//表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    /*@Test
    public void testUserMapper1()
    {//测试插入sql
        User user = new User();
        user.setUsername("tom");
        user.setPassword("020708");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }*/

    @Test
    public void testUserMapper2()
    {//测试查询sql
        User tom = userMapper.findByUsername("tom");
        System.out.println(tom);
    }
}
