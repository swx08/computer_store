package com.cy.store.service.exception;

/**
 * ClassName:PasswordNotMatchException
 * Package:com.cy.store.service.ex
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/8 - 10:46
 * @Version:v1.0
 * 登录密码与数据库密码不一致的异常
 */
public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException() {
        super();
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    protected PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
