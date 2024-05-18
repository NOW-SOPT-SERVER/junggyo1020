package org.sopt.seminar3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 모든 어플리케이션 환경에서 적용되는 객체
@EnableJpaAuditing // JPA가 엔티티를 감시할 수 있다
public class JpaAuditingConfig {
}
