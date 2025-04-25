package sopt.wangchobo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Post 클래스는 데이터베이스에 저장될 Post 엔티티를 나타냅니다.
// 이 클래스는 각 Post 객체를 데이터베이스에 저장하고 불러오는 데 사용됩니다.
@Entity
public class Post {
    // @Id 어노테이션은 이 필드가 데이터베이스에서 해당 엔티티의 기본 키(primary key)로 사용된다는 것을 의미합니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 이 필드는 데이터베이스에서 자동으로 값을 증가시켜 생성합니다.
    private Long id;

    // title과 content는 '최초 생성 시 값이 반드시 존재해야 하는 필드'라고 가정하고 final을 붙였습니다.
    // final은 해당 필드가 한 번 초기화된 후 값을 변경할 수 없다는 의미입니다.
    // 즉, 객체가 생성될 때 반드시 값을 전달받아야 하며, 이후에 변경할 수 없습니다.
    private final String title;  // 'title'은 게시물의 제목입니다.
    private final String content; // 'content'는 게시물의 내용입니다.

    // 기본 생성자는 title과 content에 null을 할당하여 기본적으로 비어있는 상태로 객체를 생성할 수 있게 합니다.
    // 이 생성자는 JPA (Java Persistence API)에서 객체를 로드할 때 필요합니다.
    // title이나 content가 필수 값이라면, 즉, 비어있는 값(빈 문자열도 포함됨)을 허용하지 않는 경우에는 ""로 초기화하는 것이 맞습니다.
    // title이나 content가 선택적인 값일 경우, 즉 값이 없을 수 있거나, 나중에 값이 설정될 수 있다면 null을 사용하는 것이 더 적합합니다
    public Post() {
        this.title = null;
        this.content = null;
    }

    // 매개변수를 받는 생성자는 새로운 Post 객체를 생성할 때 title과 content를 설정할 수 있게 해줍니다.
    // 이 생성자를 사용하면 객체를 생성할 때 필수 값들을 전달해야 합니다.
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // id, title, content에 대해 getter 메서드를 제공합니다.
    // getter 메서드는 해당 필드 값을 외부에서 읽을 수 있게 해줍니다.
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }
}
