package org.sopt.practice.repository;

import org.sopt.practice.domain.Blog;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface BlogRepository extends Repository<Blog, Long> {
    Blog save(Blog blog);
    Blog findBlogById(Long blogId);

    Optional<Blog> findById(Long blogId);
}
