package org.sopt.seminar3.service;

import lombok.RequiredArgsConstructor;
import org.sopt.seminar3.domain.Blog;
import org.sopt.seminar3.domain.Post;
import org.sopt.seminar3.dto.PostCreateRequest;
import org.sopt.seminar3.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BlogService blogService;

    public String create(Long blogId, PostCreateRequest postCreateRequest){
        //blog찾기
        Blog blog = blogService.findById(blogId);
        Post post = postRepository.save(Post.create(blog, postCreateRequest.title(), postCreateRequest.content()));
        return post.getId().toString();
    }
}
