package com.cy.store.service.exception;

/**
 * ClassName:UpdateException
 * Package:com.cy.store.service.ex
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/8 - 15:10
 * @Version:v1.0
 */
public class UpdateException extends ServiceException{
    public UpdateException() {
        super();
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    protected UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
