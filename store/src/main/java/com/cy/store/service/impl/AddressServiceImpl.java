package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ClassName:AddressServiceImpl
 * Package:com.cy.store.service.impl
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 15:18
 * @Version:v1.0
 * 新增收货地址的业务层
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private DistrictMapper districtMapper;

    @Value("${user.address.max-count}")
    private Integer maxCount;//maxCount的值在配置文件中设置过，方便后期更改
    /**
     * 新增收货地址的实现类
     * @param uid
     * @param username
     * @param address
     */
    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        //调用收货地址统计的方法
        Integer count = addressMapper.countByUid(uid);
        if(count >= maxCount){
            throw new AddressCountLimitException("用户收货地址超出上限");
        }
       // 对address对象中的数据进行补全:省市区的名字看前端代码发现前端传递过来的省市区的name分别为:
       // provinceCode,cityCode,areaCode,所以这里可以用address对象的get方法获取这三个的数据
        String provinceName = districtMapper.findNameByCode(address.getProvinceCode());
        String cityName = districtMapper.findNameByCode(address.getCityCode());
        String areaName = districtMapper.findNameByCode(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        //uid、isDefault
        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0;//1表示默认，0表示不默认
        address.setIsDefault(isDefault);
        //补全4项日志
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());

        //插入收货地址的方法
        Integer rows = addressMapper.insert(address);
        if(rows != 1){
            throw new InsertException("插入用户的收货地址产生未知异常");
        }
    }

    /**
     * 根据用户的uid来查询地址
     * @param uid
     * @return
     */
    @Override
    public List<Address> getAddressByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        /**
         * 收货地址列表在前端只展示了四个数据,这里让其他值为空降低数据量
         * ProvinceName,CityName,AreaName,aid,tel(确认订单页展示展示用户地
         * 址时用到tel)在展示地址列表用不到,但是后面提交订单时的地址会用到,所以这里不设为null
         * */
        for (Address address : list) {
            //address.setAid(null);
            address.setUid(null);
            //address.setProvinceName(null);
            address.setProvinceCode(null);
            //address.setCityName(null);
            address.setCityCode(null);
            //address.setAreaName(null);
            address.setAreaCode(null);
            address.setZip(null);
            //address.setTel(null);
            address.setIsDefault(null);
            address.setCreatedTime(null);
            address.setCreatedUser(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return list;
    }

    /**
     * 修改某个用户的某条收货地址数据为默认收货地址
     * @param aid
     * @param uid
     * @param username
     */
    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        //1.检测是否有该条收货地址数据
        Address result = addressMapper.findByAid(aid);
        if(result == null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        //2.检测当前获取到的收货地址数据的归属
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        //3.先将所有的收货地址设置为非默认
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        if(rows < 1){
            throw new UpdateException("更新数据时产生未知的异常");
        }
        //4.将用户选中的地址设置为默认收货地址
        rows = addressMapper.updateDefaultByAid(aid, username, new Date());
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知的异常");
        }
    }

    /**
     * 删除用户选中的收货地址数据
     * @param aid
     * @param uid
     * @param username
     */
    @Override
    public void delete(Integer aid, Integer uid, String username) {
        //1.检测是否有该条收货地址数据
        Address result = addressMapper.findByAid(aid);
        if(result == null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        //2.检测当前获取到的收货地址数据的归属
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        //进行删除操作
        Integer rows = addressMapper.deleteByAid(aid);
        if(rows != 1){
            throw new DeleteException("删除数据时产生未知的异常");
        }
        //4.如果删除的是非默认地址则不需要再做后面的任何操作,终止程序
        if(result.getIsDefault() == 0){
            return;
        }
        Integer count = addressMapper.countByUid(uid);
        if(count == 0){
            return;
        }
        //根据用户uid查询当前用户最后一次被修改的收货地址数据
        Address address = addressMapper.findLastModified(uid);
        //将查询到的当前用户最后一次被修改的收货地址数据设置为默认地址
        rows = addressMapper.updateDefaultByAid(address.getAid(), username, new Date());
        if(rows != 1){
            throw new UpdateException("更新数据时产生未知的异常");
        }
    }


    @Override
    public Address getByAid(Integer aid, Integer uid) {
        Address address = addressMapper.findByAid(aid);

        if (address == null) {
            throw new AddressNotFoundException("收货地址数据不存在的异常");
        }
        if (!address.getUid().equals(uid)) {
            throw new AccessDeniedException("非法访问");
        }
        address.setProvinceCode(null);
        address.setCityCode(null);
        address.setAreaCode(null);
        address.setCreatedUser(null);
        address.setCreatedTime(null);
        address.setModifiedUser(null);
        address.setModifiedTime(null);
        return address;
    }
}
