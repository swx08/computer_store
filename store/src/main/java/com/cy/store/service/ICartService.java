package com.cy.store.service;

/**
 * ClassName:ICartService
 * Package:com.cy.store.service
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 16:52
 * @Version:v1.0
 */
public interface ICartService {
    /**
     * 将商品添加到购物车
     * @param uid 当前登录用户的id
     * @param pid 商品的id
     * @param amount 增加的数量
     * @param username 当前登录的用户名
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    /**
     * 增加用户的购物车中某商品的数量
     * @param cid
     * @param uid
     * @param username
     * @return 增加成功后新的数量
     */
    Integer addNum(Integer cid,Integer uid, String username);

    /**
     * 减少用户的购物车中某商品的数量
     * @param cid
     * @param uid
     * @param username
     * @return 增加成功后新的数量
     */
    Integer reduceNum(Integer cid,Integer uid, String username);
}
