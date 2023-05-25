package idusw.springboot.boardcds.controller;

import idusw.springboot.boardcds.domain.Board;
import idusw.springboot.boardcds.domain.Member;
import idusw.springboot.boardcds.entity.MemberEntity;
import idusw.springboot.boardcds.repository.BoardRepository;
import idusw.springboot.boardcds.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2

public class BoardControllerTest {
    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    @Test
    void registerBoard() {
        Board board = Board.builder()
                .bno(1L)
                .title("title")
                .content("content")
                .writerSeq(1L)
                .writerEmail("201712010@induk.ac.kr")
                .writerName("d")
                .build();
        if(boardService.registerBoard(board) > 0 ) // 정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
            System.out.println("등록 성공");
        else
            System.out.println("등록 실패");
    }
}
