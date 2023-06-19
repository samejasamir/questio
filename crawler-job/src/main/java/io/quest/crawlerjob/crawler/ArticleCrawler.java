package io.quest.crawlerjob.crawler;

import io.quest.crawlerjob.transformer.Transformer;
import io.quest.model.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ArticleCrawler implements Crawler {
    private static final Logger LOGGER = LogManager.getLogger(ArticleCrawler.class);

    @Override
    public Article Crawl(Article article, Transformer transformer) throws IOException {
        article.setArticleRaw(Jsoup.connect(article.getArticleURL()).get().text());
        return transformer != null ? transformer.Transform(article) : article;
    }

    @Override
    public Article Crawl(Article article) throws IOException {
        return this.Crawl(article,null);
    }
}
