package com.cy.store.controller.exception;

/**
 * ClassName:FileUploadIOException
 * Package:com.cy.store.controller.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/8 - 17:42
 * @Version:v1.0
 * 文件读写异常
 */
public class FileUploadIOException extends FileUploadException {
    public FileUploadIOException() {
        super();
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    protected FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
