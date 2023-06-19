package io.quest.crawlerjob;

import io.quest.crawlerjob.pm.CrawlerPM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "io.quest.crawlerjob")
public class CrawlerJobApplication implements CommandLineRunner {
    private static final Logger LOG = LogManager.getLogger(CrawlerJobApplication.class);
    private final CrawlerPM crawlerPM;

    public CrawlerJobApplication(CrawlerPM crawlerPM) {
        this.crawlerPM = crawlerPM;
    }

    public static void main(String[] args) {
        SpringApplication.run(CrawlerJobApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception { crawlerPM.CrawlArticles(); }
}