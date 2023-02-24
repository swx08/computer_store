package com.cy.store.entity;

import lombok.*;

import java.io.Serializable;

/**
 * ClassName:User
 * Package:com.cy.store.entity
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 16:32
 * @Version:v1.0
 * 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User extends BaseEntiry implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;
}
