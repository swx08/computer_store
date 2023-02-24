package com.cy.store.entity;

import lombok.*;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.Date;

/**
 * ClassName:BaseEntiry
 * Package:com.cy.store.entity
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 16:20
 * @Version:v1.0
 * 作为实体类的基类(数据库中每个表都有这几个公共字段)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BaseEntiry implements Serializable {
    private String createdUser;
    private Date createdTime;
    private String  modifiedUser;
    private Date  modifiedTime;
}
