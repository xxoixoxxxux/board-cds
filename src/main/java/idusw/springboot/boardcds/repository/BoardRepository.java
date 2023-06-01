package idusw.springboot.boardcds.repository;

import idusw.springboot.boardcds.entity.BoardEntity;
import idusw.springboot.boardcds.repository.search.SearchBoardRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>, SearchBoardRepository {
}
