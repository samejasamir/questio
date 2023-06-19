package io.quest.crawlerjob.provider;

import io.quest.model.Article;

import java.util.List;

public interface ArticleListProvider {
    List<Article> GetArticleList();
}
