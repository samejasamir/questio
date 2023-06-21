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

//    {
//        "mediaHouse": "Morgan Stanley",
//            "articleURL": "https://www.morganstanley.com/ideas/earnings-recession-2023-rebound-2024",
//            "articleCategory": "Economic Outlook",
//            "_class": "io.quest.model.Article"
//    }
//
//    {
//        "mediaHouse": "JP Morgan",
//            "articleURL": "https://www.jpmorgan.com/insights/research/summer-travel-outlook",
//            "articleCategory": "Economic Outlook",
//            "_class": "io.quest.model.Article"
//    }
//
//    {
//        "mediaHouse": "Goldman Sachs",
//            "articleURL": "https://www.goldmansachs.com/intelligence/pages/why-a-us-recession-has-become-less-likely.html",
//            "articleCategory": "Economic Outlook",
//            "_class": "io.quest.model.Article"
//    }
