package io.quest.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Article {

    public Article(String mediaHouse, String articleURL)
    {
        this.mediaHouse = mediaHouse;
        this.articleURL = articleURL;
    }

    @Getter
    @Setter
    Date articleDated = null;

    @Getter
    @Setter
    String mediaHouse = null;

    @Getter
    @Setter
    String articleURL = null;

    @Getter
    @Setter
    String articleRaw = null;

    @Getter
    @Setter
    String articleSummary = null;

    @Getter
    @Setter
    String articleSentiment = null;
}
