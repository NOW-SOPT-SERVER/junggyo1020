package org.sopt.seminar3.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.domain.SuccessMessage;
import org.sopt.seminar3.dto.MemberFindDto;
import org.sopt.seminar3.dto.PostCreateRequest;
import org.sopt.seminar3.common.dto.SuccessResponse;
import org.sopt.seminar3.dto.PostFindDto;
import org.sopt.seminar3.repository.PostRepository;
import org.sopt.seminar3.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<SuccessResponse> createPost(
            @RequestHeader(name = "memberId") Long memberId,
            @Valid @RequestBody PostCreateRequest postCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("postId", postService.createPost(memberId, postCreateRequest))
                .body(SuccessResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostFindDto>> findAllPosts() {
        List<PostFindDto> posts = postService.findAllPosts();
        return ResponseEntity.ok(posts);
    }
}

