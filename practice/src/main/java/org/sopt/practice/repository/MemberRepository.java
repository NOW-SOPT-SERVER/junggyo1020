package org.sopt.practice.repository;

import org.sopt.practice.domain.Member;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends Repository<Member, Long> {
    Member save(Member member);
    Optional<Member> findById(Long memberId);
    void delete(Member member);

    List<Member> findAll();
}
