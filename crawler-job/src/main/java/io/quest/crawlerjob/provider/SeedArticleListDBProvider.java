package io.quest.crawlerjob.provider;

import io.quest.model.Article;
import io.quest.repository.ArticleRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedArticleListDBProvider implements ArticleListProvider {
    private static final Logger LOGGER = LogManager.getLogger(SeedArticleListDBProvider.class);

    private final ArticleRepo articleRepo;

    public SeedArticleListDBProvider(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    @Override
    public List<Article> GetArticleList() {
        return articleRepo.GetAllSeedArticles();
    }
}
