package com.cy.store.service;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName:UserServiceTests
 * Package:com.cy.store.service
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 18:35
 * @Version:v1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private IUserService iUserService;

    @Test
    public void reg()
    {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("020708");
        iUserService.regist(user);
    }
}
