package com.cy.store.service.exception;

/**
 * ClassName:CartNotFoundException
 * Package:com.cy.store.service.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 18:14
 * @Version:v1.0
 * 查询购物车商品查找失败异常
 */
public class CartNotFoundException extends ServiceException{
    public CartNotFoundException() {
        super();
    }

    public CartNotFoundException(String message) {
        super(message);
    }

    public CartNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CartNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
