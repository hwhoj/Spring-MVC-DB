package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // jpa가 관리하겠다는 선언
public class Member {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY = DB에서 PK값을 자동으로 할당해주는것
    private Long id;
    private String name;

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
