package org.sopt.practice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.auth.PrincipalHandler;
import org.sopt.practice.exception.enums.SuccessMessage;
import org.sopt.practice.exception.dto.SuccessResponse;
import org.sopt.practice.dto.request.BlogCreateRequest;
import org.sopt.practice.dto.request.BlogTitleUpdateRequest;
import org.sopt.practice.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor //의존성 주입
@RequestMapping("/api/v1")
public class BlogController {

    private final BlogService blogService;
    private final PrincipalHandler principalHandler;

    @PostMapping("/blog")
    public ResponseEntity<SuccessResponse> createBlog(
            @ModelAttribute BlogCreateRequest blogCreateRequest
    ){
        return ResponseEntity.created(URI.create(blogService.create(
                principalHandler.getUserIdFromPrincipal(), blogCreateRequest))).build();
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
