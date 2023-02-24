package com.cy.store.controller.exception;

/**
 * ClassName:FileUploadException
 * Package:com.cy.store.controller.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/8 - 17:38
 * @Version:v1.0
 * 控制层异常的基类
 */
public class FileUploadException extends RuntimeException{
    public FileUploadException() {
        super();
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
