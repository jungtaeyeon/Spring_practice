package jty.jtyspring.repository;


import jty.jtyspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // save 하면 회원이 저장소에 저장되도록
    // 그리고 저장소에서 findById, findByName 을 사용해서 찾아올 수 있도록
    // 그리고 findAll 하면 저장소에 저장된 모든 회원을 리스트를 반환하도록

    // Optional -> findById, findByName 을 불러오는데 null을 받아오면 Optional로 감싸서 반환하는 방법을 선호한다.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
