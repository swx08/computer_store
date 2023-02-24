package com.cy.store.service;

import com.cy.store.entity.User;

/**
 * ClassName:IUserService
 * Package:com.cy.store.service.impl
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 18:11
 * @Version:v1.0
 * 用户模块业务层接口
 */
public interface IUserService {
    /**
     * 用户注册方法
     * @param user
     */
    void regist(User user);

    /**
     * 用户登录方法
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);

    /**
     * 根据用户uid修改用户密码方法
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Integer changePassword(Integer uid,String username,String oldPassword,String newPassword);

    /**
     * 根据用户uid查询用户
     * @param uid
     * @return
     */
    User findByUid(Integer uid);

    /**
     * 根据用户uid查询用户
     * @param uid
     * @return
     */
    User getByUid(Integer uid);

    /**
     * 更新用户个人资料
     * @param uid
     * @param username
     * @param user
     * @return
     */
    Integer updateUserInfoByUid(Integer uid,String username,User user);

    /**
     * 上传头像
     * @param uid
     * @param avatar
     * @param username
     */
    void uploadAvatar(Integer uid,String avatar,String username);
}
