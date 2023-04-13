package idusw.springboot.boardcds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //(exclude = DataSourceAutoConfiguration.class)
public class BoardcdsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardcdsApplication.class, args);
    }

}
