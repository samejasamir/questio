package io.quest.repository;

import io.quest.model.Article;

import java.util.List;

public interface ArticleRepo {
    List<Article> GetArticles();

    void SaveArticles(List<Article> articles);

    List<Article> GetArticlesByUrl(String url);

    void SaveArticle(Article article);
}
