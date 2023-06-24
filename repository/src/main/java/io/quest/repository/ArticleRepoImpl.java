package io.quest.repository;

import io.quest.model.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleRepoImpl implements ArticleRepo{
    private static final Logger LOGGER = LogManager.getLogger(ArticleRepoImpl.class);
    private final MongoTemplate mt;
    private static final String articles_collection_name = "articles";
    private static final String seed_articles_collection_name = "articles_seed";
    private static final String col_articleURL = "articleURL";


    public ArticleRepoImpl(MongoTemplate mt) {
        this.mt = mt;
        LOGGER.info("MongoDB Database Name :: {}",mt.getDb().getName());
    }

    @Override
    public List<Article> GetAllArticles() {
        LOGGER.info("Invoking GetAllArticles...");
        var all = mt.findAll(Article.class, articles_collection_name);
        LOGGER.info("Invoking GetAllArticles SUCCESS :: {}", all == null ? "NULL" : all.stream().count());
        return all;
    }

    @Override
    public void InsertArticles(List<Article> articles) {
        LOGGER.info("Invoking InsertArticles :: {} ...", articles == null ? "NULL" : articles.stream().count());
        articles.forEach(article -> mt.insert(articles, articles_collection_name));
        LOGGER.info("Invoking GetAllArticles SUCCESS!");
    }

    @Override
    public List<Article> GetArticlesByUrl(String url) {
        LOGGER.info("Invoking GetArticlesByUrl {} ...", url);
        var val = mt.find(new Query().addCriteria(Criteria.where(col_articleURL).is(url)), Article.class);
        LOGGER.info("Invoking GetArticlesByUrl SUCCESS :: {} ...", val == null ? "NULL" : val.stream().count());
        return val;
    }

    @Override
    public void UpdateArticles(List<Article> articles) {
        LOGGER.info("Invoking UpdateArticles {} ...", articles == null ? "NULL" : articles.stream().count());
        articles.forEach(article -> {
            LOGGER.info("Saving {}", article.getArticleURL());
            mt.save(article, articles_collection_name);
            LOGGER.info("Saving SUCCESS! {}", article.getArticleURL());
        });
    }

    @Override
    public List<Article> GetAllSeedArticles() {
        LOGGER.info("Invoking GetAllSeedArticles...");
        var all = mt.findAll(Article.class, seed_articles_collection_name);
        LOGGER.info("Invoking GetAllSeedArticles SUCCESS! :: {} ...", all == null ? "NULL" : all.stream().count());
        return all;
    }
}
