package idusw.springboot.boardcds.domain;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, EN> {
    private List<DTO> dtoList; // DTO : Member, Board 객체

    private int totalPage;  // 총 페이지 번호
    private int curPage;    // 현재 페이지 번호
    private int perPage; // 한 페이지 게시물(레코드 갯수)

    private int perPagination; // 한 페이지 페이지 번호 갯수

    private long totalRows; // 총 행의 수 (총 갯수)

    private int startRow, endRow; // 시작 레코드 번호, 끝 레코드 번호

    private int start, end; // 시작 페이지 번호, 끝 페이지 번호 : 게시물
    private boolean prev, next; // 버튼 표시

    private List<Integer> pageList; // 페이지 번호 목록

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn, int perPagination) {
        totalRows = result.getTotalElements();
        dtoList = result.stream().map(fn).collect(Collectors.toList()); // get records
        totalPage = result.getTotalPages();
        this.perPagination = perPagination;
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable){
        this.curPage = pageable.getPageNumber() + 1; // 현재 페이지를 가져옴, 0부터 시작함

        this.startRow = 1 + (curPage - 1) * perPage;
        this.endRow = startRow + perPage - 1;

        this.perPage = pageable.getPageSize();

        int tempEnd = (int)(Math.ceil(curPage / ((double) perPagination))) * perPagination;

        start = tempEnd - (perPagination - 1);
        end = (totalPage > tempEnd)? tempEnd: totalPage;

        prev = start > 1;   // 1보다 크면 true, 작으면 false
        next = totalPage > tempEnd;

        // 메소드 체이닝 - 앞에 처리된 메소드가 뒤에 메소드의 매개변수가 됨. 여러 동작을 연쇄적으로 한번에 주문.
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList()); // get pageNumber list
        for(Integer i : pageList)
            System.out.println(i.intValue());
    }
}
