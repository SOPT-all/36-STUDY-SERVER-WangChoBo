package sopt.wangchobo.exception;

import sopt.wangchobo.exception.BusinessException;
import sopt.wangchobo.exception.ErrorCode;

public class NotFoundPostException extends BusinessException {
    public NotFoundPostException() {
        super(ErrorCode.NOT_FOUND_POST);
    }
}
