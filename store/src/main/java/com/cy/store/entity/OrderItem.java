package com.cy.store.entity;

import lombok.*;

import java.io.Serializable;

/**
 * ClassName:OrderItem
 * Package:com.cy.store.entity
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 19:26
 * @Version:v1.0
 * 订单中的商品数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderItem extends BaseEntiry implements Serializable {
    private Integer id;
    private Integer oid;
    private Integer pid;
    private String title;
    private String image;
    private Long price;
    private Integer num;
}
