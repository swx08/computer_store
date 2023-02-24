package com.cy.store.controller;

import com.cy.store.service.ICartService;
import com.cy.store.service.ICartVOService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:CartController
 * Package:com.cy.store.controller
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 16:56
 * @Version:v1.0
 */
@RestController
@RequestMapping("/carts")
public class CartController extends BaseController{
    @Autowired
    private ICartService cartService;

    @Autowired
    private ICartVOService cartVOService;

    @RequestMapping("/add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session) {
        cartService.addToCart(
                getUidFromSession(session),
                pid,
                amount,
                getUsernameFromSession(session));
        return new JsonResult<Void>(ok);
    }

    /**
     * 查询购物车列表(它的持久层和业务层是单独分开写的，控制层放到了现在这个CartController)
     * @param session
     * @return
     */
    @RequestMapping({"", "/"})
    public JsonResult<List<CartVo>> getVOByUid(HttpSession session) {
        List<CartVo> data = cartVOService.getVOByUid(getUidFromSession(session));
        return new JsonResult<List<CartVo>>(ok, data);
    }

    /**
     * 增加购物车商品数量
     * @param cid
     * @param session
     * @return
     */
    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
        Integer data = cartService.addNum(
                cid,
                getUidFromSession(session),
                getUsernameFromSession(session));
        return new JsonResult<Integer>(ok, data);
    }

    /**
     * 减少购物车商品数量
     * @param cid
     * @param session
     * @return
     */
    @RequestMapping("{cid}/num/reduce")
    public JsonResult<Integer> reduceNum(@PathVariable("cid") Integer cid, HttpSession session) {
        Integer data = cartService.reduceNum(
                cid,
                getUidFromSession(session),
                getUsernameFromSession(session));
        return new JsonResult<Integer>(ok, data);
    }

    /**
     * 显示勾选的购物车数据
     * @param cids
     * @param session
     * @return
     */
    @RequestMapping("/list")
    public JsonResult<List<CartVo>> getVOByCid(Integer[] cids,HttpSession session){
        List<CartVo> data = cartVOService.getVOByCid(getUidFromSession(session), cids);
        return new JsonResult<>(ok,data);
    }
}
