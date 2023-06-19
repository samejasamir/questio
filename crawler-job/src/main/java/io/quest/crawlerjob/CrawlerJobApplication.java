package io.quest.crawlerjob;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class CrawlerJobApplication implements CommandLineRunner {
    private static final Logger LOG = LogManager.getLogger(CrawlerJobApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrawlerJobApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}