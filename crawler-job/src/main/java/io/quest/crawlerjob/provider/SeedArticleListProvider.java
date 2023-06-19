package io.quest.crawlerjob.provider;

import io.quest.crawlerjob.pm.CrawlerPMImpl;
import io.quest.model.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedArticleListProvider implements ArticleListProvider {
    private static final Logger LOGGER = LogManager.getLogger(SeedArticleListProvider.class);

    @Override
    public List<Article> GetArticleList() {
        return List.of(
                new Article("Morgan Stanley","https://www.morganstanley.com/ideas/earnings-recession-2023-rebound-2024"),
                new Article("JP Morgan","https://www.jpmorgan.com/insights/research/summer-travel-outlook"),
                new Article("Goldman Sachs","https://www.goldmansachs.com/intelligence/pages/why-a-us-recession-has-become-less-likely.html")
        );
    }
}
