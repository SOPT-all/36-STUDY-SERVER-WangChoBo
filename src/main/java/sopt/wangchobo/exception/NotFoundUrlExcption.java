package sopt.wangchobo.exception;

import sopt.wangchobo.exception.BusinessException;
import sopt.wangchobo.exception.ErrorCode;

public class NotFoundUrlExcption extends BusinessException {
    public NotFoundUrlExcption() {
        super(ErrorCode.NOT_FOUND_URL);
    }
}
