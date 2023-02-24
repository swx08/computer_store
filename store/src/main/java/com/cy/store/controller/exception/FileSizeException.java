package com.cy.store.controller.exception;

/**
 * ClassName:FileSizeException
 * Package:com.cy.store.controller.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/8 - 17:41
 * @Version:v1.0
 * 文件大小超出限制
 */
public class FileSizeException extends FileUploadException{
    public FileSizeException() {
        super();
    }

    public FileSizeException(String message) {
        super(message);
    }

    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    protected FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
