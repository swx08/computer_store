package com.cy.store.controller;

import com.cy.store.entity.District;
import com.cy.store.service.IDistrictService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:DistrictController
 * Package:com.cy.store.controller
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 17:03
 * @Version:v1.0
 * 获取省市区列表的控制层
 */
@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController {
    @Autowired
    private IDistrictService iDistrictService;

    /**
     * 请求路径和父路径相同时用@RequestMapping({"/",""}),表
     * 示districts后面跟/或者什么也不跟都会进入这个方法
     * 点进RequestMapping发现参数类型是String[],且传入一
     * 个路径时默认有{},传入一个以上路径时需要手动添加{}
     */
    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent)
    {
        List<District> data = iDistrictService.getByParent(parent);
        return new JsonResult<>(ok,data);
    }

}
