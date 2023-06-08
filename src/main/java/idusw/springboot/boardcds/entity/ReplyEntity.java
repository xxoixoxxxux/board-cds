package idusw.springboot.boardcds.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티 클래스임으로 나타내는 애노테이션
@Table(name = "a201712010_reply")

@ToString(exclude = "board")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReplyEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a201712010_reply_seq_gen")
    @SequenceGenerator(sequenceName = "a201712010_reply_seq", name = "a201712010_reply_seq_gen", initialValue = 1, allocationSize = 1)
    // Oracle : GenerationType.SEQUENCE, Mysql/MariaDB : GenerationType.IDENTITY, auto_increment
    private Long rno;

    private String text; // 댓글 내용
    private String replier; // 댓글 사용자

    @ManyToOne(fetch = FetchType.LAZY) // FK : Foreign key
    private BoardEntity board; // BoardEntity : MemberEntity = N : 1,

}
