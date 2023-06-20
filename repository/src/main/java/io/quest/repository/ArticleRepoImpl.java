package io.quest.repository;

import io.quest.model.Article;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepoImpl implements ArticleRepo{
    private final MongoTemplate mt;
    private static final String col_name = "articles";

    public ArticleRepoImpl(MongoTemplate mt) {
        this.mt = mt;
    }

    @Override
    public List<Article> GetArticles() {
        return mt.findAll(Article.class);
    }

    @Override
    public void SaveArticles(List<Article> articles) {
        mt.insert(articles,col_name);
    }

    @Override
    public List<Article> GetArticlesByUrl(String url) {
        return mt.find(new BasicQuery("{url:}"), Article.class);
    }

    @Override
    public void SaveArticle(Article article) {

    }
}
