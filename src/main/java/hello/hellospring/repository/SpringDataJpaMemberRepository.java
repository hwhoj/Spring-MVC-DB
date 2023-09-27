package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // interfacte가 implements 받을때는 extends이다, 인터페이스는 다중상속 가능

    @Override
    Optional<Member> findByName(String name);
}
