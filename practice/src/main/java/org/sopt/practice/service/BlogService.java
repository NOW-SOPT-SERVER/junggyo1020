package org.sopt.practice.service;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.Blog;
import org.sopt.practice.domain.Member;
import org.sopt.practice.dto.request.BlogCreateRequest;
import org.sopt.practice.dto.request.BlogTitleUpdateRequest;
import org.sopt.practice.external.S3Service;
import org.sopt.practice.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;
    private final S3Service s3Service;
    private static final String BLOG_S3_UPLOAD_FOLDER = "blog/";

    @Transactional
    public String create(Long memberId, BlogCreateRequest request){
        //member 찾기
        Member member = memberService.findById(memberId);
        try {
            Blog blog = blogRepository.save(
                    Blog.create(member, request.title(), request.description(),
                            s3Service.uploadImage(BLOG_S3_UPLOAD_FOLDER, request.image())));
            return blog.getId().toString();
        } catch (RuntimeException | IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest request){
        Blog blog = blogRepository.findBlogById(blogId);
        blog.updateTitle(request.title());
    }
}
