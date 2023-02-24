package com.cy.store.service.exception;

/**
 * ClassName:AddressCountLimitException
 * Package:com.cy.store.service.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 15:17
 * @Version:v1.0
 * 如果查询的结果>=20,这时需要抛出业务控制的异常
 */
public class AddressCountLimitException extends ServiceException{
    public AddressCountLimitException() {
        super();
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
