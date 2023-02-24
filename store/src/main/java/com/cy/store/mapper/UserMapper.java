package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * ClassName:UserMapper
 * Package:com.cy.store.mapper
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 16:41
 * @Version:v1.0
 */
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user
     * @return首影响的行数(增删改都受影响的行数作为返回值，可以根据返回值类判断执行是否成功)
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username
     * @return找到返回user,找不到返回null值
     */
    User findByUsername(@Param("username") String username);

    /**
     * changePassword方法需要什么参数:
     * 要先看底层持久层需要什么参数:uid,password,modifiedUser,modifiedTime
     * 1.修改人其实就是username,已经保存到session当中,通过控制层传递过来就行了
     * 2.在更新数据之前需要先根据uid查这个数据存不存在,uid也可以通过控制层传递
     * 3.新密码需要有
     * 4.修改时间不需要在参数列表,直接在方法内部new Date()就可以了
     * 5.旧密码
     * */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * 根据用户uid来查询用户
     */
    User findByUid(Integer uid);

    /**
     * 更新用户个人资料
     */
    Integer updateUserInfoByUid(User user);

    /**
     * 上传头像
     */
    Integer updateAvatarByUid(Integer uid,String avatar, String modifiedUser, Date modifiedTime);
}
