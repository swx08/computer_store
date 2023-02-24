package com.cy.store.entity;

import lombok.*;

import java.io.Serializable;

/**
 * ClassName:Product
 * Package:com.cy.store.entity
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 15:40
 * @Version:v1.0
 * 商品实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product extends BaseEntiry implements Serializable {
    private Integer id;
    private Integer categoryId;
    private String itemType;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String image;
    private Integer status;
    private Integer priority;
}
