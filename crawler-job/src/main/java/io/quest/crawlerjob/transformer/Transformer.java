package io.quest.crawlerjob.transformer;

import io.quest.model.Article;

public interface Transformer {
    Article Transform(Article article);
}
