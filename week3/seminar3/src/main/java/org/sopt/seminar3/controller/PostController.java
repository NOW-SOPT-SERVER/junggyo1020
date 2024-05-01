package org.sopt.seminar3.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.domain.SuccessMessage;
import org.sopt.seminar3.dto.PostCreateRequest;
import org.sopt.seminar3.dto.SuccessStatusResponse;
import org.sopt.seminar3.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader Long blogId,
            @RequestBody PostCreateRequest postCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                        "Location",
                        postService.create(blogId, postCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }
}

