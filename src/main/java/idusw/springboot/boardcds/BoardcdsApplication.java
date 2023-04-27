package idusw.springboot.boardcds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication  //(exclude = DataSourceAutoConfiguration.class)
// @Configuration : 해당 클래스가 설정 클래스 임을 Spring Framework 에게 알림
@EnableJpaAuditing // JPA Auditing 을 활성화함
public class BoardcdsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardcdsApplication.class, args);
    }

}
