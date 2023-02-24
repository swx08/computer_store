package com.cy.store.service;

import com.cy.store.entity.Address;

import java.util.List;

/**
 * ClassName:AddressService
 * Package:com.cy.store.service
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 15:18
 * @Version:v1.0
 * 新增收货地址的业务层
 */
public interface IAddressService {
    /**
     * 新增收货地址的实现
     * @param uid
     * @param username
     * @param address
     */
    void addNewAddress(Integer uid, String username, Address address);

    /**
     * 根据用户的uid来查询地址
     * @param uid
     * @return
     */
    List<Address> getAddressByUid(Integer uid);

    /**
     * 修改某个用户的某条收货地址数据为默认收货地址
     * @param aid
     * @param uid
     * @param username
     */
    void setDefault(Integer aid,Integer uid,String username);

    /**
     * 删除用户选中的收货地址数据
     * @param aid
     * @param uid
     * @param username
     */
    void delete(Integer aid,Integer uid,String username);

    Address getByAid(Integer aid, Integer uid);
}
