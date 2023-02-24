package com.cy.store.service;

import com.cy.store.vo.CartVo;

import java.util.List;

/**
 * ClassName:ICartVOService
 * Package:com.cy.store.service
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 17:43
 * @Version:v1.0
 */
public interface ICartVOService {
    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    List<CartVo> getVOByUid(Integer uid);

    /**
     * 显示勾选的购物车数据
     * @param cids 用户id
     * @return 该用户的购物车数据的列表
     */
    List<CartVo> getVOByCid(Integer uid,Integer[] cids);
}
