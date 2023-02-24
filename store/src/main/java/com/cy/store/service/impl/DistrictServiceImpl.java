package com.cy.store.service.impl;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:DistrictServiceImpl
 * Package:com.cy.store.service.impl
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 16:34
 * @Version:v1.0
 * 获取省市区列表的业务层
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    /**
     * 根据父代号来查询区域信息(省市区)
     * @param parent
     * @return
     */
    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        /**
         * 在进行网络数据传输时,为了尽量避免无效数据的传递,可以将无效数据
         * 设置为null,这样既节省流量,又提升了效率
         */
        for(District d : list){
            d.setId(null);
            d.setParent(null);
        }
        return list;
    }

    /**
     * 通过code获取市区名字
     * @param code
     * @return
     */
    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
