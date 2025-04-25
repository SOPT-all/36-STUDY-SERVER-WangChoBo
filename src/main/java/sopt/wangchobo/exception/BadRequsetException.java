package sopt.wangchobo.exception;

public class BadRequsetException extends BusinessException {
    public BadRequsetException() {
        super(ErrorCode.BAD_REQUEST);
    }
}
