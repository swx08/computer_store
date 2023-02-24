package com.cy.store.util;

import java.io.Serializable;

/**
 * ClassName:JsonResult
 * Package:com.cy.store.util
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 19:07
 * @Version:v1.0
 * Json格式的数据响应给前端
 */
public class JsonResult<E> implements Serializable {
    //状态码
    private Integer state;
    //扫描信息
    private String message;
    //数据
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }
    //异常
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
