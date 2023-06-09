package com.cy.store.controller;

import com.cy.store.controller.exception.*;
import com.cy.store.service.exception.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * ClassName:BaseController
 * Package:com.cy.store.controller
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 19:24
 * @Version:v1.0
 * 控制层的基类
 */
public class BaseController {
    //操作成功的状态码
    public static final int ok = 200;
    //请求处理方法:这个方法的返回值就是需要传递给前端的数据
    //自动将异常对象传递给此方法的参数列表上
    //当前项目中产生了异常，被统一拦截到此方法中，这个方法此时就充当的是请求处理方法(全局异常配置)
    @ExceptionHandler({ServiceException.class,FileUploadException.class})//用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicateException){
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        }else if(e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }else if(e instanceof UsernameNotFoundException) {
            result.setState(4001);
            result.setMessage("用户名不存在");
        }else if(e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("用户密码错误");
        }else if(e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("更新数据时产生未知的异常");
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("文件为空");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMessage("文件大小超出限制");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMessage("文件类型不支持");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("文件状态异常");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("文件读写错误");
        }else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
            result.setMessage("用户的收货地址超出上限的异常");
        }else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("用户的收货地址不存在的异常");
        }else if (e instanceof AccessDeniedException) {
            result.setState(4005);
            result.setMessage("收货地址数据非法访问的异常");
        }else if (e instanceof DeleteException) {
            result.setState(4006);
            result.setMessage("删除数据时产生未知的异常");
        }else if (e instanceof ProductNotFoundException) {
            result.setState(4007);
            result.setMessage("访问的商品数据不存在的异常");
        }else if (e instanceof CartNotFoundException) {
            result.setState(4008);
            result.setMessage("购物车表不存在该商品的异常");
        }
        return result;
    }

    /**
     * 获取session对象中的uid
     * @param session session对象
     * @return 当前登录的用户uid的值
     */
    protected Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取session对象中的username
     * @param session session对象
     * @return 当前登录的用户username的值
     */
    protected String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
