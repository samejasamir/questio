package io.quest.model;

import lombok.*;
import org.bson.BsonObjectId;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

//@Document("articles")
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    public Article(String mediaHouse, String articleURL, String articleCategory)
    {
        this.mediaHouse = mediaHouse;
        this.articleURL = articleURL;
        this.articleCategory = articleCategory;

    }

    @Field("_id")
    @Getter
    @Setter
    private BsonObjectId articleId;

    @Getter
    @Setter
    private String articleTitle;

    @Getter
    @Setter
    private Date articleCrawlDate = null;

    @Getter
    @Setter
    private String mediaHouse = null;

    @Getter
    @Setter
    private String articleURL = null;

    @Getter
    @Setter
    private String articleRaw = null;

    @Getter
    @Setter
    private String articleSummary = null;

    @Getter
    @Setter
    private String articleSentiment = null;

    @Getter
    @Setter
    private String articleCategory = null;
}
