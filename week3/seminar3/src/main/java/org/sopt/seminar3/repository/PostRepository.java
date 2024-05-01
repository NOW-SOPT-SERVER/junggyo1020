package org.sopt.seminar3.repository;

import org.sopt.seminar3.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
