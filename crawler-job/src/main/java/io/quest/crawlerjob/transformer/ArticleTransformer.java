package io.quest.crawlerjob.transformer;

import io.quest.model.Article;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ArticleTransformer implements Transformer {

    private static final Logger LOGGER = LogManager.getLogger(ArticleTransformer.class);

    @Override
    public Article Transform(Article article) {
        return article;
    }
}
