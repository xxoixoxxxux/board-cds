package idusw.springboot.boardcds.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티 클래스임으로 나타내는 애노테이션
@Table(name = "ab_reply")

@ToString(exclude = "board")   // lombok 라이브러리 사용
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ab_reply_seq_gen")
    @SequenceGenerator(sequenceName = "ab_reply_seq", name = "ab_reply_seq_gen", initialValue = 1, allocationSize = 1)
    // Oracle : GenerationType.SEQUENCE, Mysql/MariaDB : GenerationType.IDENTITY, auto increment
    private Long rno;

    private String text; // 댓글
    private String  replier; // 댓글 사용자

    @ManyToOne(fetch = FetchType.LAZY) // board 조인을 늦추겠다. 딱 필요한 시점에 쓰겠다.
    private BoardEntity board; // BoardEntity : MemberEntity = N : 1
}
