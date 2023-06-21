package io.quest.summerizerjob;

import io.quest.summerizerjob.summerizer.ResearchArticleSummerizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.quest")
public class SummerizerJobApplication implements CommandLineRunner {

    private static final Logger LOGGER = LogManager.getLogger(SummerizerJobApplication.class);
    private final ResearchArticleSummerizer researchArticleSummerizer;

    public SummerizerJobApplication(ResearchArticleSummerizer researchArticleSummerizer) {
        this.researchArticleSummerizer = researchArticleSummerizer;
    }

    public static void main(String[] args) {
        SpringApplication.run(SummerizerJobApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception { researchArticleSummerizer.Summerize(); }
}
