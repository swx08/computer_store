package com.cy.store.mapper;

import com.cy.store.entity.Product;

import java.util.List;

/**
 * ClassName:ProductMapper
 * Package:com.cy.store.mapper
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 15:41
 * @Version:v1.0
 */
public interface ProductMapper {
    /**
     * 查询热销商品的前四名
     * @return
     */
    List<Product> findHotList();

    /**
     *根据商品id查询商品详情
     * @param id
     * @return
     */
    Product findById(Integer id);
}
