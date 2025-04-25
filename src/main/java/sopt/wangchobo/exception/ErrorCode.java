package sopt.wangchobo.exception;

import org.springframework.http.HttpStatus; // HTTP 상태 코드를 쉽게 다루기 위한 스프링의 도구

/*
 * ✅ ErrorCode: 에러 코드들을 모아놓은 enum(열거형) 클래스예요.
 * 에러마다 고유한 상태코드, 숫자코드, 메시지를 정해줄 수 있어요.
 */
public enum ErrorCode { // 🔸 'enum'은 '선택 가능한 값들을 미리 정해둔 집합'이라고 생각하면 돼요.

    // 각각의 에러를 정의한 부분이에요.
    // 괄호 안에는 (HttpStatus, 고유 숫자 코드, 설명 메시지)를 넣어요.

    NOT_FOUND_URL(HttpStatus.NOT_FOUND, 40401, "지원하지 않는 URL입니다."),
    NOT_FOUND_POST(HttpStatus.NOT_FOUND, 40402, "존재하지 않는 게시물입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, 40501, "잘못된 HTTP method 요청입니다."), // 오타 수정: HPPT → HTTP

    BAD_REQUEST(HttpStatus.BAD_REQUEST, 40001, "잘못된 요청입니다.");

    /*
     * 🔒 필드: 위에 정의한 값들을 저장할 공간이에요.
     * private: 외부에서 직접 접근하지 못하게 막고, 메서드를 통해서만 값을 꺼내게 해요.
     * final: 한 번 정해지면 바꿀 수 없어요. 에러 코드는 바뀌면 안 되니까 final로 고정해요!
     */
    private final HttpStatus status; // HTTP 상태 코드 (예: 404 Not Found)
    private final int code;          // 우리가 직접 정한 고유 숫자 코드 (예: 40401)
    private final String msg;        // 사용자에게 보여줄 메시지

    /*
     * 🧱 생성자: enum 값이 만들어질 때 위 필드들을 초기화해주는 역할을 해요.
     * 외부에서는 이 생성자를 호출할 수 없고, 위에 정의한 상수들만 쓸 수 있어요!
     */
    ErrorCode(HttpStatus status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    /*
     * 🧰 getter 메서드: private으로 숨겨둔 필드 값을 꺼낼 수 있도록 도와줘요.
     * public: 외부에서도 이 메서드를 통해 값을 얻을 수 있게 열어둡니다.
     */
    public HttpStatus getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
