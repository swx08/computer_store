package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * ClassName:UserServiceImpl
 * Package:com.cy.store.service.impl
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 18:13
 * @Version:v1.0
 * 用户模块业务层的实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;//调用持久层的方法

    /**
     * 用户注册方法实现
     * @param user
     */
    @Override
    public void regist(User user) {
        User username = userMapper.findByUsername(user.getUsername());
        //判断username是否为null
        if(username != null){
            //抛出异常
            throw new UsernameDuplicateException("用户名被占用");
        }
        //密码加密处理的实现:md5算法的形式
        //(串 + password + 串) ---- md5算法进行加密，连续加载三次
        //盐值 + password + 盐值 ---- 盐值就是一个随机的字符串
        String oldPassword = user.getPassword();
        //获取盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //补全数据：保存盐值
        user.setSalt(salt);
        //将密码和盐值作为一个整体进行加密处理
        String md5Password = getMD5Password(oldPassword, salt);
        //将加密之后的密码重新补全设置到user对象中
        user.setPassword(md5Password);

        //补全数据:
        user.setIsDelete(0);
        //补全数:4个日志字段信息
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        user.setCreatedTime(new Date());
        user.setModifiedTime(new Date());

        //执行注册业务功能的实现(rows==1)
        Integer rows = userMapper.insert(user);
        if(rows != 1){
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    /**
     * 用户登录方法实现
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        //根据用户名称来查询用户的数据是否存在,不存在则抛出异常
        User result = userMapper.findByUsername(username);
        if(result == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //检测用户的密码是否匹配
        //1.获取数据库中加密之后的密码
        String oldPassword = result.getPassword();
        //2.和用户传递过来的密码进行比较
        //2.1先获取盐值
        String salt = result.getSalt();
        String newMD5Password = getMD5Password(password, salt);
        //2.2将获取的用户密码按照相同的md5算法加密
        if(!oldPassword.equals(newMD5Password)){
            throw new PasswordNotMatchException("用户密码错误");
        }
        //3.判断is_delete字段的值是否为1，为1表示被标记为删除
        if(result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //4.方法login返回的用户数据是为了辅助其他页面做数据展示使用(只会用到uid,username,avatar)
        //所以可以new一个新的user只赋这三个变量的值,这样使层与层之间传输时数据体量变小,后台层与
        // 层之间传输时数据量越小性能越高,前端也是的,数据量小了前端响应速度就变快了
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    /**
     *
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public Integer changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户名不存在");
        }
        String oldMD5Password = getMD5Password(oldPassword, result.getSalt());
        if(!result.getPassword().equals(oldMD5Password)){
            throw new PasswordNotMatchException("用户密码错误");
        }
        String newMD5Password = getMD5Password(newPassword, result.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newMD5Password, username, new Date());
        if(rows != 1){
            throw new UpdateException("更新数据产生未知的异常");
        }

        return rows;
    }

    /**
     * 根据用户uid查询用户
     * @param uid
     * @return
     */
    @Override
    public User findByUid(Integer uid) {
        return userMapper.findByUid(uid);
    }

    /**
     * 根据用户uid查询用户
     * @param uid
     * @return
     */
    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //new一个新的user赋这4个变量的值,这样使层与层之间传输时数据体量变小,后台层与
        //层之间传输时数据量越小性能越高,前端也是的,数据量小了前端响应速度就变快了
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    /**
     * 修改用户个人资料
     * @param uid
     * @param username
     * @param user
     * @return
     */
    @Override
    public Integer updateUserInfoByUid(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户名不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateUserInfoByUid(user);
        if(rows !=1){
            throw new UpdateException("更新数据时产生未知的错误");
        }
        return rows;
    }

    /**
     * 上传头像
     * @param uid
     * @param avatar
     * @param username
     */
    @Override
    public void uploadAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户名不存在");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if(rows != 1){
            throw new UpdateException("更新用户头像时产生未知异常");
        }
    }

    /**
     * 定义一个md5的加密处理
     * @param password
     * @param salt
     * @return
     */
    private String getMD5Password(String password,String salt){
        for(int i = 0;i < 3;i++){
            //md5加密算法方法的调用(进行三次加密)
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        //返回加密之后的密码
        return password;
    }

}
