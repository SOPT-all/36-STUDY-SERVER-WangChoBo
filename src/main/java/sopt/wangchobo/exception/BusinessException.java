package sopt.wangchobo.exception;

/**
 * ❗️비즈니스 로직에서 예외가 발생했을 때 사용하는 커스텀 예외 클래스예요!
 * 예: 존재하지 않는 게시물을 조회하려고 할 때, 중복된 아이디를 만들려고 할 때 등등
 */
public class BusinessException extends RuntimeException {

    // 📌 어떤 종류의 에러인지 저장하는 변수예요 (예: 40401 - 게시물 없음)
    private final ErrorCode errorCode;

    /**
     * 📌 BusinessException 생성자(객체를 만들 때 사용하는 코드)
     * 외부에서 에러코드를 넣어서 이 예외를 만들 수 있게 해줘요
     *
     * @param errorCode : ErrorCode enum에서 정의한 에러 종류를 넘겨줘요
     */
    public BusinessException(ErrorCode errorCode) {
        // 부모 클래스인 RuntimeException에게 에러 메시지를 전달해요
        // 나중에 로그로 확인하거나 에러 화면에 띄울 수 있어요
        super(errorCode.getMsg());

        // 우리가 만든 errorCode 필드에도 저장해요
        this.errorCode = errorCode;
    }

    /**
     * 📌 에러 코드를 꺼내고 싶을 때 사용하는 메서드
     * 예외가 발생했을 때, 어떤 에러였는지 확인하려고 호출해요
     *
     * @return errorCode : 발생한 에러의 상세 정보
     */
    public ErrorCode getFailCode() {
        return errorCode;
    }
}
