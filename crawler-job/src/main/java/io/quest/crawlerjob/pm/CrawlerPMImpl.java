package io.quest.crawlerjob.pm;

import io.quest.crawlerjob.crawler.Crawler;
import io.quest.crawlerjob.provider.ArticleListProvider;
import io.quest.crawlerjob.transformer.Transformer;
import io.quest.model.Article;
import io.quest.repository.ArticleRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CrawlerPMImpl implements CrawlerPM {
    private static final Logger LOGGER = LogManager.getLogger(CrawlerPMImpl.class);
    private final ArticleListProvider provider;
    private final Crawler crawler;
    private final Transformer transformer;
    private final ArticleRepo articleRepo;

    public CrawlerPMImpl(ArticleListProvider provider, Crawler crawler, Transformer transformer, ArticleRepo articleRepo) {
        this.provider = provider;
        this.crawler = crawler;
        this.transformer = transformer;
        this.articleRepo = articleRepo;
    }

    @Override
    public void CrawlArticles() throws IOException {
        LOGGER.info("Starting CrawlArticles");
        var articles = provider.GetArticleList();
        LOGGER.info("Articles to crawl :: {}", articles == null ? "NULL" : articles.stream().count());
        articles.forEach(article -> {
            try {
                crawler.Crawl(article, transformer);
            } catch (IOException e) {
                LOGGER.error(e);
            }
        });
        articleRepo.UpdateArticles(articles);
    }
}
