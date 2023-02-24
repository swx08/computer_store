package com.cy.store.service.exception;

/**
 * ClassName:InsertException
 * Package:com.cy.store.service.ex
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/7 - 18:09
 * @Version:v1.0
 * 数据在插入过程中所产生的异常
 */
public class InsertException extends ServiceException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
