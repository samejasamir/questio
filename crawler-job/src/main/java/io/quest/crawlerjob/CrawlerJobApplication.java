package io.quest.crawlerjob;

import io.quest.crawlerjob.pm.CrawlerPM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.quest")
public class CrawlerJobApplication implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(CrawlerJobApplication.class);
    private final CrawlerPM crawlerPM;

    public CrawlerJobApplication(CrawlerPM crawlerPM) {
        this.crawlerPM = crawlerPM;
    }

    public static void main(String[] args) {
        SpringApplication.run(CrawlerJobApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Initialized {}, running CrawlAricles", CrawlerJobApplication.class.getSimpleName());
        crawlerPM.CrawlArticles();
    }
}