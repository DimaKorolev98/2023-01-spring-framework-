package com.example.otus_project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.otus_project")
@EnableJpaRepositories(basePackages = "com.example.otus_project.repositories")
@EntityScan(basePackages = "com/example/otus_project/domain")
public class AirPlainShop {

    public static void main(String[] args) {

        SpringApplication.run(AirPlainShop.class, args);

    }

}
