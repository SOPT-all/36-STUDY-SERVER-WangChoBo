package sopt.wangchobo.dto;

// PostRequest 클래스는 사용자가 새로운 게시글을 작성할 때 필요한 데이터를 담는 역할을 합니다.
// 여기에는 'title'(제목)과 'content'(내용) 두 가지 필드가 있습니다.
// 이 클래스는 DTO(Data Transfer Object)로, 데이터만을 전달하는 역할을 하며,
// 비즈니스 로직이나 데이터 저장 로직은 포함하지 않습니다.

public record PostRequest(
        // 제목을 나타내는 필드입니다. 사용자로부터 게시글의 제목을 받을 때 사용됩니다.
        String title,

        // 게시글의 내용을 나타내는 필드입니다. 사용자가 작성한 게시글의 내용을 받을 때 사용됩니다.
        String content
) {
    // 이 부분은 Java의 'record' 타입으로, 불변(immutable) 객체를 생성하는 데 사용됩니다.
    // record는 생성자, equals(), hashCode(), toString() 메서드 등을 자동으로 제공합니다.
    // 따라서, 'title'과 'content'에 값을 설정하고 해당 값들을 그대로 반환하는 객체가 됩니다.
}
