package sopt.wangchobo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.wangchobo.dto.PostRequest;
import sopt.wangchobo.dto.PostResponse;
import sopt.wangchobo.dto.Response;
import sopt.wangchobo.service.PostService;

@RestController
public class PostController {

    // PostService 객체를 의존성 주입(DI) 방식으로 받습니다.
    // Spring에서는 이와 같이 외부에서 객체를 주입받는 방식을 통해 객체 간의 의존성을 해결합니다.
    private final PostService postService;

    // 생성자입니다. 이 생성자에서는 'PostService' 객체를 받아 'postService' 변수에 할당합니다.
    // Spring은 'PostService' 클래스를 자동으로 생성하고 주입해줍니다.
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // @PostMapping은 HTTP POST 요청을 처리하는 메서드를 정의하는 어노테이션입니다.
    // "/post" URL로 POST 요청이 들어오면 이 메서드가 호출됩니다.
    // 이 메서드는 사용자가 새로운 게시글을 생성할 때 요청을 받습니다.
    @PostMapping("/posts")
    public ResponseEntity<Response<Void>> createPost(@RequestBody PostRequest postRequest) {
        // PostRequest는 클라이언트가 보낸 요청의 본문(body)을 담고 있습니다.
        // 여기서 postRequest는 사용자가 입력한 'title'과 'content'를 담고 있습니다.

        // postService의 createPost 메서드를 호출하여 실제로 게시글을 생성합니다.
        // 이 때 PostRequest 객체를 전달합니다.
        postService.createPost(postRequest);

        // 성공적인 처리가 되었음을 나타내는 응답(ResponseEntity)을 반환합니다.
        // Response.success(null)은 성공적인 응답을 나타내며, 데이터는 없으므로 'null'을 전달합니다.
        // ResponseEntity.ok()는 HTTP 200 OK 상태 코드로 응답을 보냅니다.
        return ResponseEntity.ok(Response.success(null));
    }

    // @GetMapping은 HTTP GET 요청을 처리하는 메서드를 정의하는 어노테이션입니다.
    // "/post/{id}" URL로 GET 요청이 들어오면 이 메서드가 호출됩니다.
    // {id}는 URL의 변수 부분으로, 요청할 게시글의 ID를 전달받습니다.
    // 이 메서드는 특정 ID를 가진 게시글을 조회하는 기능을 담당합니다.
    @GetMapping("/posts/{id}")
    public ResponseEntity<Response<PostResponse>> getPost(@PathVariable Long id) {
        // @PathVariable 어노테이션을 사용하여 URL에서 전달된 {id} 값을 메서드 인자 'id'로 받습니다.
        // 'id'는 조회할 게시글의 고유 ID를 나타냅니다.

        // postService의 getPost 메서드를 호출하여 특정 ID를 가진 게시글을 조회합니다.
        // 조회된 게시글은 PostResponse 객체로 반환됩니다.
        PostResponse postResponse = postService.getPost(id);

        // 조회된 게시글을 포함한 응답(ResponseEntity)을 반환합니다.
        // Response.success(postResponse)는 조회된 게시글 정보를 클라이언트에 전달합니다.
        return ResponseEntity.ok(Response.success(postResponse));
    }

}
