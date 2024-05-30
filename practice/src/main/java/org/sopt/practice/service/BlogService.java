package org.sopt.practice.service;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.Blog;
import org.sopt.practice.domain.Member;
import org.sopt.practice.dto.request.BlogCreateRequest;
import org.sopt.practice.dto.request.BlogTitleUpdateRequest;
import org.sopt.practice.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    @Transactional
    public String create(Long memberId, BlogCreateRequest request){
        //member 찾기
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, request.title(), request.description()));
        return blog.getId().toString();
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest request){
        Blog blog = blogRepository.findBlogById(blogId);
        blog.updateTitle(request.title());
    }
}
