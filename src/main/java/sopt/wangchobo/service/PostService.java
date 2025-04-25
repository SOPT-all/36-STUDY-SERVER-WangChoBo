package sopt.wangchobo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.wangchobo.domain.Post;
import sopt.wangchobo.dto.PostRequest;
import sopt.wangchobo.dto.PostResponse;
import sopt.wangchobo.exception.NotFoundPostException;
import sopt.wangchobo.repository.PostRepository;


@Service // 이 클래스가 Spring에서 서비스 역할을 하는 클래스임을 나타냅니다.
public class PostService {

    // PostRepository 객체를 의존성 주입(DI) 방식으로 받습니다.
    // Spring에서는 이와 같이 외부에서 객체를 주입받는 방식을 통해 객체 간의 의존성을 해결합니다.
    private final PostRepository postRepository;

    // 생성자입니다. 이 생성자에서는 'PostRepository' 객체를 받아 'postRepository' 변수에 할당합니다.
    // Spring은 'PostRepository' 클래스를 자동으로 생성하고 주입해줍니다.
    // 이때, PostService가 사용해야 하는 'PostRepository'가 자동으로 연결됩니다.
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // @Transactional 어노테이션을 사용하여 이 메서드가 하나의 트랜잭션 내에서 실행되도록 보장합니다.
    // 트랜잭션은 데이터베이스 작업을 하나의 일괄 작업으로 묶어서 처리합니다.
    // 예를 들어, 게시글 저장 도중 오류가 발생하면 데이터베이스에 반영된 내용도 모두 취소됩니다.
    @Transactional
    public void createPost(PostRequest postRequest) {
        // 'PostRequest'는 클라이언트가 보낸 게시글의 제목과 내용을 담고 있습니다.
        // 이를 기반으로 'Post' 객체를 생성합니다. 'Post' 객체는 데이터베이스에 저장할 게시글의 데이터를 나타냅니다.
        Post post = new Post(postRequest.title(), postRequest.content());

        // 'PostRepository'를 사용하여 'post' 객체를 데이터베이스에 저장합니다.
        // 'save()' 메서드는 객체를 데이터베이스에 저장하는 역할을 합니다.
        postRepository.save(post); // 게시글 저장
    }

    // 특정 ID를 가진 게시글을 조회하는 메서드입니다.
    public PostResponse getPost(Long id) {
        // 'findById'는 주어진 'id'로 게시글을 찾습니다.
        // 게시글이 없으면 'NotFoundPostException'을 던집니다.
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundPostException());

        // 게시글이 존재하면 'PostResponse' 객체를 생성하여 반환합니다.
        // 'PostResponse'는 클라이언트에 전달할 게시글의 데이터만 담고 있는 객체입니다.
        return new PostResponse(post.getId(), post.getTitle(), post.getContent());
    }

}

