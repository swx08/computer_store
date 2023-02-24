package com.cy.store.service.impl;

import com.cy.store.mapper.CartVOMapper;
import com.cy.store.service.ICartVOService;
import com.cy.store.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * ClassName:CartVOServiceImpl
 * Package:com.cy.store.service.impl
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 17:44
 * @Version:v1.0
 */
@Service
public class CartVOServiceImpl implements ICartVOService {
    @Autowired
    private CartVOMapper cartVOMapper;
    /**
     * 查询购物车列表
     * @param uid 用户id
     * @return
     */
    @Override
    public List<CartVo> getVOByUid(Integer uid) {
        return cartVOMapper.findVOByUid(uid);
    }

    /**
     * 显示勾选的购物车数据
     * @param cids 用户id
     * @return
     */
    @Override
    public List<CartVo> getVOByCid(Integer uid,Integer[] cids) {
        List<CartVo> list = cartVOMapper.findVOByCid(cids);
        Iterator<CartVo> iterator = list.iterator();
        while (iterator.hasNext()){
            CartVo cartVo = iterator.next();
            if(!cartVo.getUid().equals(uid)){//表示当前的数据不属于当前的用户
                list.remove(cartVo);//从集合中移除这个元素
            }
        }
        return list;
    }
}
