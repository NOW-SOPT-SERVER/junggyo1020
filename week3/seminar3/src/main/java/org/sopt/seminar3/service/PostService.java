package org.sopt.seminar3.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.sopt.seminar3.domain.Blog;
import org.sopt.seminar3.domain.Post;
import org.sopt.seminar3.dto.MemberFindDto;
import org.sopt.seminar3.dto.PostCreateRequest;
import org.sopt.seminar3.dto.PostFindDto;
import org.sopt.seminar3.exception.BlogNotFoundException;
import org.sopt.seminar3.exception.NotFoundException;
import org.sopt.seminar3.exception.message.ErrorMessage;
import org.sopt.seminar3.repository.BlogRepository;
import org.sopt.seminar3.repository.MemberRepository;
import org.sopt.seminar3.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BlogRepository blogRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public String createPost(Long memberId, PostCreateRequest postCreateRequest){
        memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );
        Blog blog  = blogRepository.findById(memberId).orElseThrow(
                () -> new BlogNotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION)
        );
        Post post = postRepository.save(Post.createPost(blog, postCreateRequest.title(), postCreateRequest.content()));
        postRepository.save(post);
        return post.toString();
    }
    // post 리스트 모든 post를 조회하는 메서드 추가하기
    public List<PostFindDto> findAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> new PostFindDto(post.getTitle(), post.getContent()))
                .collect(Collectors.toList());
    }
}
