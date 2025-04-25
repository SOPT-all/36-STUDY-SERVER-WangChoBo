package sopt.wangchobo.dto;

// JSON으로 데이터를 보낼 때, 값이 null인 건 빼고 보내도록 설정해주는 애노테이션이에요.
// 예: data가 null이면 JSON으로 보낼 때 data는 아예 안 보냄
import com.fasterxml.jackson.annotation.JsonInclude;

// HTTP 상태 코드를 쉽게 쓰게 해주는 스프링에서 제공하는 도구예요.
// 예: 200은 성공, 404는 못 찾음, 500은 서버 에러 같은 숫자 코드들을 미리 정리해 둔 거예요
import org.springframework.http.HttpStatus;
import sopt.wangchobo.exception.ErrorCode;

/*
 * 이 클래스는 API 응답의 틀(형태)을 정해주는 역할을 해요.
 * 서버가 프론트엔드(또는 사용자)에게 어떤 결과를 보낼지 이 틀을 따라 보내요.
 * 제네릭<T>을 사용해서 어떤 데이터든 유연하게 담을 수 있어요.
 */

// @JsonInclude(JsonInclude.Include.NON_NULL): 응답을 JSON으로 바꿀 때, null인 필드는 빼줍니다.
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Response<T>( // record: 데이ㅊ터를 간단하게 표현할 수 있는 자바 문법 (Java 16부터 가능)
                           boolean success,   // 요청이 성공했는지(true) 실패했는지(false) 알려주는 값
                           int code,        // HTTP 상태 코드 숫자 (예: 200, 404 등)
                           String msg,        // 성공 또는 실패에 대한 설명 메시지
                           T data             // 응답으로 보낼 실제 데이터 (T는 어떤 타입이든 가능!)
) {

    /*
     * ✅ 성공 응답을 만들어주는 도구(메서드)예요.
     * static: 객체를 따로 만들지 않아도 바로 사용 가능해요!
     * <T>: 이 메서드도 어떤 타입의 데이터를 받을 수 있도록 제네릭을 사용해요.
     */
    public static <T> Response<T> success(T data, String msg) {
        // true(성공), 상태코드 200, 메시지, 데이터를 담아서 Response를 만들어서 리턴!
        return new Response<>(true, HttpStatus.OK.value(), msg, data);
        // HttpStatus.OK.value(): 숫자 200을 의미해요 (성공했다는 뜻!)
    }

    /*
     * ✅ 성공 응답 (메시지를 따로 안 줄 경우 기본 메시지를 넣어주는 메서드)
     * 예: 그냥 data만 주면 자동으로 "응답이 성공적으로 이루어졌습니다."라는 메시지를 넣어줘요!
     */
    public static <T> Response<T> success(T data) {
        return success(data, "응답이 성공적으로 이루어졌습니다.");
    }

    /*
     * ❌ 실패 응답을 만들어주는 메서드예요.
     * 실패했을 땐 success를 false로 하고, 데이터는 null로 줘요.
     * HttpStatus를 통해 상태 코드 숫자를 가져와서 넣어요.
     */
    public static <T> Response<T> fail(ErrorCode errorCode) {
        return new Response<>(false, errorCode.getCode(), errorCode.getMsg(), null);
    }
}
