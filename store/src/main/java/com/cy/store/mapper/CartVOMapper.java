package com.cy.store.mapper;

import com.cy.store.vo.CartVo;

import java.util.List;

/**
 * ClassName:CartVOMapper
 * Package:com.cy.store.mapper
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 17:38
 * @Version:v1.0
 */
public interface CartVOMapper {
    /**
     * 查询购物车列表
     * @param uid
     * @return
     */
    List<CartVo> findVOByUid(Integer uid);

    /**
     * 显示勾选的购物车数据
     * @param cids
     * @return
     */
    List<CartVo> findVOByCid(Integer[] cids);
}
