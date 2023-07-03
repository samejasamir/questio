package io.quest.crawlerjob.crawler;

import io.quest.crawlerjob.transformer.Transformer;
import io.quest.model.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ArticleCrawler implements Crawler {
    private static final Logger LOGGER = LogManager.getLogger(ArticleCrawler.class);

    @Override
    public Article Crawl(Article article, Transformer transformer) throws IOException {
        LOGGER.info("Crawling :: {}", article.getArticleURL());

        var jdoc = Jsoup.connect(article.getArticleURL()).get();

        // Try extracting title
        var headingElement = jdoc.getElementsByTag("h1");
        if(headingElement.size() > 0)
            article.setArticleTitle(headingElement.text());
        else
            article.setArticleTitle(jdoc.title());

        //Timestamp crawl
        article.setArticleCrawlDate(new Date());

        //Set raw article
        article.setArticleRaw(jdoc.text());
        LOGGER.info("Crawling SUCCESS! :: {}", article.getArticleURL());
        return transformer != null ? transformer.Transform(article) : article;
    }

    @Override
    public Article Crawl(Article article) throws IOException {
        return this.Crawl(article,null);
    }
}
