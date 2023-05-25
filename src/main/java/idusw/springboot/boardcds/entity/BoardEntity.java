package idusw.springboot.boardcds.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티 클래스임으로 나타내는 애노테이션
@Table(name = "member_a201712010")

@ToString(exclude = "writer")   // lombok 라이브러리 사용
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// @Data // == @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
// JPA Auditing 을 활용하여서 생성한사람, 생성일자, 수정한사람, 수정일자 등을 선택하여서 감사
public class BoardEntity extends BaseEntity {
    // Entity : Service -> Repository -> Service 데이터 객제, Database 관점
    // Repository : Persistence Data 처리
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_a201712010_seq_gen")
    @SequenceGenerator(sequenceName = "member_a201712010_seq", name = "member_board_seq_gen", initialValue = 1, allocationSize = 1)
    // Oracle : GenerationType.SEQUENCE, Mysql/MariaDB : GenerationType.IDENTITY, auto increment
    private Long bno;

    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String content;
    @ManyToOne
    //@JoinColumn(name = "seq")
    private MemberEntity writer;
}
