package kr.co.planhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PlanHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanHubApplication.class, args);
    }
}
