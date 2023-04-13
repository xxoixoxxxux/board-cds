package idusw.springboot.boardcds.repository;

import idusw.springboot.boardcds.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

}
