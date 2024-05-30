package org.sopt.practice.service;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.exception.enums.SuccessMessage;
import org.sopt.practice.exception.dto.SuccessResponse;
import org.sopt.practice.domain.Blog;
import org.sopt.practice.domain.Post;
import org.sopt.practice.dto.request.PostCreateRequest;
import org.sopt.practice.dto.response.PostFindDto;
import org.sopt.practice.exception.NotFoundException;
import org.sopt.practice.exception.enums.ErrorMessage;
import org.sopt.practice.repository.BlogRepository;
import org.sopt.practice.repository.MemberRepository;
import org.sopt.practice.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BlogRepository blogRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createPost(Long memberId, Long blogId, PostCreateRequest postCreateRequest){
        memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION));

        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION));

        if(!blog.getMember().getId().equals(memberId)){
            throw new NotFoundException(ErrorMessage.MEMBER_NOT_OWNED_BLOG_EXCEPTION);
        }

        postRepository.save(Post.create(blog, postCreateRequest.title(), postCreateRequest.content()));
    }

    public SuccessResponse<PostFindDto> getPostById(Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_ID_EXCEPTION));

        Blog blog = post.getBlog();
        if(blog == null){
            throw new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION);
        }

        PostFindDto postFindDto = PostFindDto.of(post);
        postRepository.save(post);

        return SuccessResponse.of(SuccessMessage.POST_GET_SUCCESS, postFindDto);
    }
}
