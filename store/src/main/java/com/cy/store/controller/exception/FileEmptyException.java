package com.cy.store.controller.exception;

/**
 * ClassName:FileEmptyException
 * Package:com.cy.store.controller.exception
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/8 - 17:40
 * @Version:v1.0
 * 文件为空的异常(没有选择上传的文件就提交了表单,或选择的文件是0字节的空文件)
 */
public class FileEmptyException extends FileUploadException{
    public FileEmptyException() {
        super();
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
