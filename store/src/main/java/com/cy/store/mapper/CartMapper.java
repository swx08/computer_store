package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * ClassName:CartMapper
 * Package:com.cy.store.mapper
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 16:47
 * @Version:v1.0
 */
public interface CartMapper {
    /**
     * 插入购物车数据
     * @param cart 购物车数据
     * @return 受影响的行数
     */
    Integer insert(Cart cart);

    /**
     * 修改购物车数据中商品的数量
     * @param cid 购物车数据的id
     * @param num 新的数量
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateNumByCid(
            @Param("cid") Integer cid,
            @Param("num") Integer num,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据用户id和商品id查询购物车中的数据
     * @param uid 用户id
     * @param pid 商品id
     * @return 匹配的购物车数据，如果该用户的购物车中并没有该商品，则返回null
     */
    Cart findByUidAndPid(@Param("uid") Integer uid, @Param("pid") Integer pid);

    /**
     * 增加购物车商品数量
     * @param cid
     * @return
     */
    Cart findByCid(Integer cid);

}
