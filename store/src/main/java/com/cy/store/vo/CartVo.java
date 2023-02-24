package com.cy.store.vo;

import lombok.*;

import java.io.Serializable;

/**
 * ClassName:CartVo
 * Package:com.cy.store.vo
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 17:34
 * @Version:v1.0
 * 当查询得到的结果集没有一个实体类来接收时一般可以用value Object(VO)来接收
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CartVo implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
    private String title;
    private Long realPrice;
    private String image;
}
