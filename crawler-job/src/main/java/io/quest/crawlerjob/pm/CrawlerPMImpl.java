package io.quest.crawlerjob.pm;

import io.quest.crawlerjob.crawler.ArticleCrawler;
import io.quest.crawlerjob.crawler.Crawler;
import io.quest.crawlerjob.provider.ArticleListProvider;
import io.quest.crawlerjob.transformer.Transformer;
import io.quest.model.Article;
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

    public CrawlerPMImpl(ArticleListProvider provider, Crawler crawler, Transformer transformer) {
        this.provider = provider;
        this.crawler = crawler;
        this.transformer = transformer;
    }

    @Override
    public void CrawlArticles() throws IOException {
        var seedArticles = provider.GetArticleList();
        for(Article seedArticle : seedArticles) {
            var art = crawler.Crawl(seedArticle, transformer);
            LOGGER.info(art.getArticleRaw());
        }
    }
}
