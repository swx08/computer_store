package com.cy.store.entity;

import lombok.*;

import java.io.Serializable;

/**
 * ClassName:Cart
 * Package:com.cy.store.entity
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 16:45
 * @Version:v1.0
 * 购物车数据的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cart extends BaseEntiry implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
}
