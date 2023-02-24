package com.cy.store.service.exception;

/**
 * ClassName:ProductNotFoundException
 * Package:com.cy.store.service.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 16:09
 * @Version:v1.0
 */
public class ProductNotFoundException extends ServiceException{
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
