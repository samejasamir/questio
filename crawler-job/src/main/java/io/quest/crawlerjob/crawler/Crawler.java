package io.quest.crawlerjob.crawler;

import io.quest.crawlerjob.transformer.Transformer;
import io.quest.model.Article;

import java.io.IOException;

public interface Crawler {
    Article Crawl(Article article, Transformer transformer) throws IOException;
    Article Crawl(Article article) throws IOException;
}
