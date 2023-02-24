package com.cy.store.service.exception;

/**
 * ClassName:ServiceException
 * Package:com.cy.store.service.ex
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 18:04
 * @Version:v1.0
 * 业务层异常的基类：规划异常
 */
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
