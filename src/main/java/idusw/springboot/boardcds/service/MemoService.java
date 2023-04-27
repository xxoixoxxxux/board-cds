package idusw.springboot.boardcds.service;

import idusw.springboot.boardcds.domain.Member;
import idusw.springboot.boardcds.domain.Memo;
import idusw.springboot.boardcds.domain.PageResultDTO;
import idusw.springboot.boardcds.entity.MemberEntity;

import java.util.List;

public interface MemoService {
    int create(Memo m);
    Memo read(Memo m);  // mno 값을 넘김
    List<Memo> readList();
    int update(Memo m);
    int delete(Memo m);
}
