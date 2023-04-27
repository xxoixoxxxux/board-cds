package idusw.springboot.boardcds.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티 클래스임으로 나타내는 애노테이션
@Table(name = "member_a201712010")

@ToString   // lombok 라이브러리 사용
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@SequenceGenerator(sequenceName = "member_a201712010_seq", name = "member_a201712010_seq_gen",
        initialValue = 1, allocationSize = 1)
// sequence : 일련번호를 담고 있는 객체, 일반적으로 테이블 하나당 sequence 하나
// nextval - 새로운 번호 / currval - 만든 번호 읽기 => nextval로 만든 번호를 currval로 읽어들임.
public class MemberEntity extends BaseEntity {
    // Entity : Service -> Repository -> Service 데이터 객제, Database 관점
    // Repository : Persistence Data 처리
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_a201712010_seq_gen")
    // Oracle : GenerationType.SEQUENCE, Mysql : GenerationType.IDENTITY
    // Mysql : auto increment, Oracle : sequence - 자동증가 식별번호
    private Long seq;

    @Column(length = 30, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String pw;
}

// JPA는 구현체 x, 표준 정의서, 인터페이스들의 집합
// hibernate : JPA를 구현한 구현체, persistence data framework