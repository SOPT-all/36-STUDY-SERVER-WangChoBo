package sopt.wangchobo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.NoHandlerFoundException;
import sopt.wangchobo.dto.Response;

/**
 * GlobalExceptionHandler: 전역 예외 처리기 클래스입니다.
 * - 이 클래스는 애플리케이션 전역에서 발생할 수 있는 예외를 처리하고,
 * - 클라이언트에게 일관된 형식의 응답을 반환하는 역할을 합니다.
 * - Spring에서 제공하는 @ControllerAdvice를 사용해 작성합니다.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * BusinessException을 처리하는 메서드입니다.
     * @param e BusinessException: 비즈니스 로직에서 발생한 예외 객체
     * @return ResponseEntity<Response>: 실패한 API 응답을 일관된 형식으로 반환
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response<Object>> handleBusinessException(BusinessException e) {
        // BusinessException에서 발생한 에러 정보를 가져옵니다.
        ErrorCode errorCode = e.getFailCode();

        // ResponseEntity를 사용해 실패 응답을 반환합니다.
        return ResponseEntity
                .status(errorCode.getStatus())  // 실패한 HTTP 상태 코드
                .body(Response.fail(errorCode));  // Response.fail을 통해 ErrorCode를 사용
    }

    /**
     * HTTP 메서드가 잘못된 요청으로 발생하는 예외를 처리하는 메서드입니다.
     * @param e HttpRequestMethodNotSupportedException: 잘못된 HTTP Method 요청을 나타내는 예외 객체
     * @return ResponseEntity<Response>: 실패한 API 응답을 반환
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Response<Object>> handleMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        // 잘못된 HTTP Method 요청에 대해 ErrorCode를 사용하여 응답 반환
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(Response.fail(ErrorCode.METHOD_NOT_ALLOWED));
    }

    /**
     * 잘못된 요청 본문(JSON 형식이 잘못된 경우)을 처리하는 예외 메서드입니다.
     * @param e HttpMessageNotReadableException: 요청 본문이 잘못된 형식일 때 발생
     * @return ResponseEntity<Response>: 실패한 API 응답을 반환
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response<Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        // 잘못된 요청 본문에 대해 ErrorCode를 사용하여 응답 반환
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Response.fail(ErrorCode.BAD_REQUEST));
    }

    /**
     * 존재하지 않는 URL에 대한 요청을 처리하는 예외를 처리하는 메서드입니다.
     * @param e NoHandlerFoundException: 요청한 URL에 대한 핸들러가 없을 때 발생하는 예외
     * @return ResponseEntity<Response>: 실패한 API 응답을 반환
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Response<Object>> handleNoHandlerFound(NoHandlerFoundException e) {
        // 잘못된 URL에 대해 ErrorCode를 사용하여 응답 반환
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Response.fail(ErrorCode.NOT_FOUND_URL));
    }
}