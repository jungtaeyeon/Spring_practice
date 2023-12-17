package jty.jtyspring.repository;

import jty.jtyspring.domain.Member;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    // 아래 save를 할 때 저장해둔 공간 필요
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // sequence > 자동으로 0, 1, 2, .. 이렇게 자동으로 키값 생성해줌

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Optional.ofNullable() -> null이 반환될 경우를 위해 사용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // -> 루프 돌리기
                .filter(member -> member.getName().equals(name)) // 람다식..
                .findAny(); // 하나라도 찾는 것 -> 이 결과가 Optional로 반환된다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
