package io.quest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.quest")
public class QuestIOServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(QuestIOServiceMain.class, args);
    }

}