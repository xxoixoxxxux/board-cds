package idusw.springboot.boardcds.service;

import idusw.springboot.boardcds.domain.Board;
import idusw.springboot.boardcds.entity.BoardEntity;
import idusw.springboot.boardcds.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public int registerBoard(Board dto) {

        BoardEntity entity = dtoToEntity(dto);

        if(boardRepository.save(entity) != null) // 저장 성공
            return 1;
        else
            return 0;
    }

    @Override
    public Board findBoardById(Board board) {
        return null;
    }

    @Override
    public List<Board> findBoardAll() {
        return null;
    }

    @Override
    public int updateBoard(Board board) {
        return 0;
    }

    @Override
    public int deleteBoard(Board board) {
        return 0;
    }
}
