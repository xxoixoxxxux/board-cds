package idusw.springboot.boardcds.service;

import idusw.springboot.boardcds.domain.Member;
import idusw.springboot.boardcds.entity.MemberEntity;
import idusw.springboot.boardcds.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class MemberServiceImpl implements MemberService {
    MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public int create(Member m) {
        MemberEntity entity = MemberEntity.builder()
                .seq(m.getSeq())
                .email(m.getEmail())
                .name(m.getName())
                .pw(m.getPw())
                .build();
        if(memberRepository.save(entity) != null) // 저장 성공
            return 1;
        else
            return 0;
    }

    @Override
    public Member read(Member m) {
        MemberEntity e = memberRepository.getById(m.getSeq());
        Member member = Member.builder()
                .seq(m.getSeq())
                .email(m.getEmail())
                .name(m.getName())
                .pw(m.getPw())
                .build();
        return member;
    }

    @Override
    public List<Member> readList() {
        List<Member> result = new ArrayList<>(); // Memo 객체를 원소로 갖는 리스트형 객체를 생성, 배정
        List<MemberEntity> entities = memberRepository.findAll(); // select * from a_memo;
        for(MemberEntity e : entities) {
            Member m = Member.builder()
                    .seq(e.getSeq())
                    .email(e.getEmail())
                    .name(e.getName())
                    .pw(e.getPw())
                    .build(); // DTO (Data Transfer Object) : Controller - Service or Controller - View
            result.add(m);
        }
        return result;
    }

    @Override
    public int update(Member m) {
        return 0;
    }

    @Override
    public int delete(Member m) {
        return 0;
    }
}
