package com.cy.store.mapper;

import com.cy.store.entity.Address;

import java.util.Date;
import java.util.List;

/**
 * ClassName:AddressMapper
 * Package:com.cy.store.mapper
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 15:02
 * @Version:v1.0
 * 新增收货地址的持久层
 */
public interface AddressMapper {
    /**
     * 插入用户的收货地址数据
     * @param address
     * @return 影响的行数
     */
    Integer insert(Address address);

    /**
     * 根据用户的uid统计收货地址数量
     * @param uid
     * @return 当前用户的收货地址总数
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户的uid来查询地址
     * @param uid
     * @return 收货地址数据
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据aid查询收货地址数据
     * @param aid
     * @return
     */
    Address findByAid(Integer aid);

    /**
     * 根据用户的uid值来修改用户的收货地址设置为非默认
     * @param uid
     * @return 受影响的行数
     */
    Integer updateNonDefaultByUid(Integer uid);

    /**
     * 修改用户的默认收货地址
     * @param aid
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateDefaultByAid(Integer aid, String modifiedUser, Date modifiedTime);

    /**
     * 根据收货地址的aid删除收货地址数据
     * @param aid
     * @return
     */
    Integer deleteByAid(Integer aid);

    /**
     * 根据用户uid查询当前用户最后一次被修改的收货地址数据
     * @param uid
     * @return
     */
    Address findLastModified(Integer uid);

    /**
     * 通过用户的uid修改收获地址
     * @param address
     * @return
     */
    Integer update(Address address);
}
