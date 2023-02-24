package com.cy.store.mapper;

import com.cy.store.entity.District;

import java.util.List;

/**
 * ClassName:DistrictMapper
 * Package:com.cy.store.mapper
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 16:22
 * @Version:v1.0
 * 获取省市区列表的持久层
 */
public interface DistrictMapper {
    /**
     * 根据父代号查询区域信息
     * @param parent
     * @return某个父区域下的所有区域
     */
    List<District> findByParent(String parent);

    /**
     * 通过code获取市区名字
     * @param code
     */
    String findNameByCode(String code);
}
