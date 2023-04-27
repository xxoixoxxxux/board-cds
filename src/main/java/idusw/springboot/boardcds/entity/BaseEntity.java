package idusw.springboot.boardcds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
// JPA Auditing 을 위한 공통 추상 클래스
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
// 추상 클래스로 만든 이유 : 객체 생성하지 마라! 상속만 받을 것! / 추상 메서드가 있다면 추상 클래스로 지정 해줘야 함.
// 추상 메서드 : 선언부만 작성하고 구현부 작성 x
    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
