package com.cy.store.service;

import com.cy.store.entity.Product;

import java.util.List;

/**
 * ClassName:ProductMapperService
 * Package:com.cy.store.service
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 15:46
 * @Version:v1.0
 */
public interface IProductService {
    /**
     * 查询热销商品的前四名
     * @return
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详情
     * @param id
     * @return
     */
    Product findById(Integer id);
}
