package org.sopt.seminar3.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.domain.Blog;
import org.sopt.seminar3.domain.SuccessMessage;
import org.sopt.seminar3.dto.BlogCreateRequest;
import org.sopt.seminar3.dto.BlogTitleUpdateRequest;
import org.sopt.seminar3.dto.SuccessStatusResponse;
import org.sopt.seminar3.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader(name = "memberId") Long memberId, // 멤버 식별자는 중요한 정보이므로 헤더를 통해 받아옴
            @RequestBody BlogCreateRequest blogCreateRequest
    ){
        return ResponseEntity.status(HttpStatus.CREATED).header(
                "Location",
                        blogService.create(memberId, blogCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
    ){
        blogService.updateTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.noContent().build();
    }
}