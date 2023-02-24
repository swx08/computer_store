package com.cy.store.service.exception;

/**
 * ClassName:UsernameNotFoundException
 * Package:com.cy.store.service.ex
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/8 - 10:47
 * @Version:v1.0
 * 用户名找不到的异常
 */
public class UsernameNotFoundException extends ServiceException{
    public UsernameNotFoundException() {
        super();
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UsernameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
