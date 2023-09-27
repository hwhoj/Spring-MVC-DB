package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        //test를 실행하기전에 준비해두는 작업

        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        // test 한개가 돌고나면 DB값을 전부 날려준다
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //테스트 코드는 한글이든 자기가 보기편하게 바꿔도됨

        // given : 뭔가가 주어지고
        Member member = new Member();
        member.setName("spring");

        // when : 이것을 실행했을 때
        Long saveId = memberService.join(member);

        // then : 이러한 결과가 나와야한다
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외(){
        // 테스트는 예외플로우 처리하는게 더 중요하다

        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
        try, catch 쓸수 있지만 복잡함
        try {
            memberService.join(member2);
            fail();
        } catch(IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/

        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}