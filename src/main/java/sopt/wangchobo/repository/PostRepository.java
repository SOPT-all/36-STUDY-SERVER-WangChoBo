package sopt.wangchobo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.wangchobo.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // JpaRepository를 상속받음으로써, Post 엔티티에 대한 CRUD (Create, Read, Update, Delete) 기능을 자동으로 제공받습니다.
    // JpaRepository는 Spring Data JPA에서 제공하는 인터페이스로, 데이터베이스와의 상호작용을 쉽게 할 수 있도록 해줍니다.
    // 기본적으로 제공하는 메서드들: save(), findAll(), findById(), deleteById() 등
}
