package com.cy.store.service;

import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ClassName:DistrictTest
 * Package:com.cy.store.service
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 17:14
 * @Version:v1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictTest {
    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent() {
        //86代表中国,所有的省父代码号都是86
        List<District> list = districtService.getByParent("86");
        for (District district : list) {
            System.out.println(district);
        }
    }
}
