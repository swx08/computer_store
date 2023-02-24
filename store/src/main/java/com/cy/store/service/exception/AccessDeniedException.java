package com.cy.store.service.exception;

/**
 * ClassName:AccessDeniedException
 * Package:com.cy.store.service.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 21:04
 * @Version:v1.0
 */
public class AccessDeniedException extends ServiceException{
    public AccessDeniedException() {
        super();
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    protected AccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
