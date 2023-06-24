package io.quest.services;

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
public class ArticleServiceImplV1 implements ArticleService {

    private static final Logger LOGGER = LogManager.getLogger(ArticleServiceImplV1.class);
    private final ArticleRepo articleRepo;

    public ArticleServiceImplV1(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    @Override
    @GetMapping(value = "/all", produces = "application/json")
    public List<Article> GetAllArticles()
    {
        LOGGER.info("Invoking GetAllArticles operation...");
        return articleRepo.GetAllArticles();
    }
}
