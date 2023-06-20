package io.quest.repository;

import io.quest.model.Article;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepoImpl implements ArticleRepo{
    private final MongoTemplate mt;
    private static final String collection_name = "articles";
    private static final String col_articleURL = "articleURL";


    public ArticleRepoImpl(MongoTemplate mt) {
        this.mt = mt;
    }

    @Override
    public List<Article> GetArticles() {
        return mt.findAll(Article.class);
    }

    @Override
    public void SaveArticles(List<Article> articles) {
        mt.insert(articles, collection_name);
    }

    @Override
    public List<Article> GetArticlesByUrl(String url) {
        return mt.find(new Query().addCriteria(Criteria.where(col_articleURL).is(url)), Article.class);
    }

    @Override
    public void SaveArticle(Article article) {

    }
}
