package org.sopt.seminar3.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.domain.Blog;
import org.sopt.seminar3.domain.Member;
import org.sopt.seminar3.dto.BlogCreateRequest;
import org.sopt.seminar3.dto.BlogTitleUpdateRequest;
import org.sopt.seminar3.exception.BlogNotFoundException;
import org.sopt.seminar3.exception.NotFoundException;
import org.sopt.seminar3.exception.message.ErrorMessage;
import org.sopt.seminar3.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    @Transactional
    public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
        //member찾기
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest.title(), blogCreateRequest.description()));
        return blog.getId().toString();
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest){
        Blog blog  = blogRepository.findById(blogId).orElseThrow(
                () -> new BlogNotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION)
        );
        blog.updateTitle(blogTitleUpdateRequest.title());
    }
}