package jty.jtyspring.domain;

public class Member {
    private Long id; // 고객이 정하는 id가 아닌 시스템이 임의로 정하는 id
    private String name; // 고객이 회원가입할 때 적는 이름

    public Long getId() { 
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
