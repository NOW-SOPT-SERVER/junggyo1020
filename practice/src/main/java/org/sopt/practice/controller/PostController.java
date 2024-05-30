package org.sopt.practice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.exception.enums.SuccessMessage;
import org.sopt.practice.exception.dto.SuccessResponse;
import org.sopt.practice.dto.request.PostCreateRequest;
import org.sopt.practice.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<SuccessResponse> createPost(
            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest
    ){
        postService.createPost(memberId, blogId, postCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<SuccessResponse> getPostById(
            @PathVariable Long postId
    ){
        SuccessResponse response = postService.getPostById(postId);

        return ResponseEntity.ok(response);
    }
}
