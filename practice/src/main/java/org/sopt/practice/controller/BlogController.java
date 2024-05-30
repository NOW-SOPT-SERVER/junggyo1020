package org.sopt.practice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.exception.enums.SuccessMessage;
import org.sopt.practice.exception.dto.SuccessResponse;
import org.sopt.practice.dto.request.BlogCreateRequest;
import org.sopt.practice.dto.request.BlogTitleUpdateRequest;
import org.sopt.practice.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor //의존성 주입
@RequestMapping("/api/v1")
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<SuccessResponse> createBlog(
            @RequestHeader Long memberId,
            @RequestBody BlogCreateRequest blogCreateRequest
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", blogService.create(memberId, blogCreateRequest))
                .body(SuccessResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest request
    ){
        blogService.updateTitle(blogId, request);
        return ResponseEntity.noContent().build();
    }
}
