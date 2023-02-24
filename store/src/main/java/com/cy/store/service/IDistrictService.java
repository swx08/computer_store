package com.cy.store.service;

import com.cy.store.entity.District;

import java.util.List;

/**
 * ClassName:DistrictService
 * Package:com.cy.store.service
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 16:31
 * @Version:v1.0
 * 获取省市区列表的业务层
 */
public interface IDistrictService {
    /**
     * 根据父代号来查询区域信息(省市区)
     * @param parent
     * @return多个区域的信息
     */
    List<District> getByParent(String parent);

    /**
     * 通过code获取市区名字
     * @param code
     * @return
     */
    String getNameByCode(String code);
}
