package org.sopt.clonecoding.repository;

import org.sopt.clonecoding.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
