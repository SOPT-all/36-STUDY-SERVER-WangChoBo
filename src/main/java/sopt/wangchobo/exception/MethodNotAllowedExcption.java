package sopt.wangchobo.exception;

/**
 * MethodNotAllowedException 클래스는 HTTP 요청에서 잘못된 메서드가 사용되었을 때 발생하는 예외입니다.
 * 예를 들어, GET 방식으로 요청해야 할 API에 POST 방식으로 요청하는 경우에 사용됩니다.
 * 이 클래스는 BusinessException을 상속받아, ErrorCode.METHOD_NOT_ALLOWED를 설정합니다.
 */
public class MethodNotAllowedExcption extends BusinessException {

    /**
     * 생성자: MethodNotAllowedException 객체를 만들 때 호출됩니다.
     * 이 생성자는 상위 클래스인 BusinessException의 생성자에 'ErrorCode.METHOD_NOT_ALLOWED'를 전달하여
     * HTTP 상태 코드 405(지원하지 않는 HTTP 메서드)와 관련된 메시지를 설정합니다.
     */
    public MethodNotAllowedExcption() {
        // 'ErrorCode.METHOD_NOT_ALLOWED'는 잘못된 HTTP 메서드 요청에 대해 설정한 에러 코드입니다.
        // 이 코드를 사용하면, 상태 코드 405와 메시지 "잘못된 HTTP method 요청입니다."가 자동으로 설정됩니다.
        super(ErrorCode.METHOD_NOT_ALLOWED);
    }
}


