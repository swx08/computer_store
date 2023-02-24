package com.cy.store.controller.exception;

/**
 * ClassName:FileTypeException
 * Package:com.cy.store.controller.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/8 - 17:42
 * @Version:v1.0
 * 文件类型异常(上传的文件类型超出了限制)
 */
public class FileTypeException extends FileUploadException{
    public FileTypeException() {
        super();
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    protected FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
