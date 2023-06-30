package io.quest.services.v1;

import io.quest.model.Article;
import io.quest.repository.ArticleRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("v1/articles")
public class ArticleServiceImpl implements ArticleService {

    private static final Logger LOGGER = LogManager.getLogger(ArticleServiceImpl.class);
    private final ArticleRepo articleRepo;

    public ArticleServiceImpl(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    @Override
    @GetMapping(value = "/all", produces = "application/json")
    public List<Article> GetAllArticles()
    {
        LOGGER.info("Invoking GetAllArticles operation...");
        var retVal = articleRepo.GetAllArticles();

        // No need to send raw article back to UI
        retVal.forEach(article -> article.setArticleRaw(null));
        return retVal;
    }
}
