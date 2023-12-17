package jty.jtyspring.service;

import jty.jtyspring.domain.Member;
import jty.jtyspring.repository.MemberRepository;
import jty.jtyspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService  {
    private final MemberRepository memberRepository;

    public MemberService(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 안된다.
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
//           Optional<Member> result = memberRepository.findByName(member.getName());
//           result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

//         위 코드를 아래와 같이 바로 깔끔하게 사용할 수 있다.
//         왜?? -> findByName() 반환값이 Optional 이기 때문에!
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

//        if(result != null) { throw new IllegalStateException("이미 존재하는 회원입니다."); } -> 아래와 같은 식

//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

//        result.ifPresent -> result에 null이 아니라 값이 있으면~ () 이 실행된다! Optional이기때문에 가능
//        람다식 -> result에 값이 있는 경우 m이 그 값에 해당한다.
    }

    /**
     * 전체 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
