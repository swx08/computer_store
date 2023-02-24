package com.cy.store.service;

import com.cy.store.entity.Order;

/**
 * ClassName:IOrderService
 * Package:com.cy.store.service
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 19:37
 * @Version:v1.0
 */
public interface IOrderService {

    /**
     * 用于创建订单
     * @param aid
     * @param cids
     * @param uid
     * @param username
     * @return
     */
    Order create(Integer aid, Integer[] cids, Integer uid, String username);
}
