package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:AddressController
 * Package:com.cy.store.controller
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 15:41
 * @Version:v1.0
 * 新增收货地址的控制层
 */
@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController{
    @Autowired
    private IAddressService iAddressService;

    /**
     * 新增收货地址的请求处理
     * @param address
     * @param session
     * @return
     */
    @RequestMapping("/add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session)
    {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        iAddressService.addNewAddress(uid,username,address);
        return new JsonResult<>(ok);
    }

    /**
     * 根据用户的uid来查询地址(收货地址列表展示)
     * @param session
     * @return
     */
    @RequestMapping({"","/"})
    public JsonResult<List<Address>> getByUid(HttpSession session)
    {
        Integer uid = getUidFromSession(session);
        List<Address> data = iAddressService.getAddressByUid(uid);
        return new JsonResult<>(ok,data);
    }

    /**
     * 修改用户的默认地址(RestFul风格的请求编写)
     * @param aid
     * @param session
     * @return
     */
    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(
            @PathVariable("aid") Integer aid, HttpSession session) {
        iAddressService.setDefault(
                aid,
                getUidFromSession(session),
                getUsernameFromSession(session));
        return new JsonResult<>(ok);
    }

    /**
     * 删除用户的收货地址
     * @param aid
     * @param session
     * @return
     */
    @RequestMapping("{aid}/delete")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid,HttpSession session) {
        iAddressService.delete(
                aid,
                getUidFromSession(session),
                getUsernameFromSession(session));
        return new JsonResult<>(ok);
    }
}
