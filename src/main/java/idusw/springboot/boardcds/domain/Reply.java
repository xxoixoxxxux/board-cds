package idusw.springboot.boardcds.domain;

import java.time.LocalDateTime;

public class Reply {
    private Long rno;
    private String text;
    private String replier;
    private Long bno; // board 와 ManyToOne 관계
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
