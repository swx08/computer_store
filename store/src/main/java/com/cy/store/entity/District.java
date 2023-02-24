package com.cy.store.entity;

import lombok.*;

import java.io.Serializable;

/**
 * ClassName:District
 * Package:com.cy.store.entity
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 16:19
 * @Version:v1.0
 * 省市区的数据实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class District extends BaseEntiry implements Serializable {
    private Integer id;
    private String parent;
    private String code;
    private String name;
}
