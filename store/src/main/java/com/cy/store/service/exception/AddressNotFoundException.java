package com.cy.store.service.exception;

/**
 * ClassName:AddressNotFoundException
 * Package:com.cy.store.service.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/9 - 21:03
 * @Version:v1.0
 */
public class AddressNotFoundException extends ServiceException{
    public AddressNotFoundException() {
        super();
    }

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
