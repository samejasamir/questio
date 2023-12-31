package io.quest.repository;

import io.quest.model.Article;

import java.util.List;

public interface ArticleRepo {
    List<Article> GetAllArticles();

    void InsertArticles(List<Article> articles);

    List<Article> GetArticlesByUrl(String url);

    void UpdateArticles(List<Article> articles);

    List<Article> GetAllSeedArticles();

}
