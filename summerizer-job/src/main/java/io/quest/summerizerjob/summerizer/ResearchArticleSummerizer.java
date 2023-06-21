package io.quest.summerizerjob.summerizer;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import io.quest.model.Article;
import io.quest.repository.ArticleRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchArticleSummerizer implements ArticleSummerizer {

    private static final Logger LOG = LogManager.getLogger(ResearchArticleSummerizer.class);

    private final ArticleRepo articleRepo;

//    private final static String ALGO_SUFFIX = "\\n\\nTl;dr";

    public ResearchArticleSummerizer(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    @Override
    public void Summerize() {
        List<Article> articles = articleRepo.GetAllArticles();
        articles.forEach(article -> GenerateSummary(article));
        articleRepo.UpdateArticles(articles);
    }

    private void GenerateSummary(Article article)
    {
        OpenAiService service = new OpenAiService("TOKEN");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(article.getArticleRaw() )
                .model("test")
                .build();

        var choices = service.createCompletion(completionRequest).getChoices();
        article.setArticleSummary(choices.get(0).getText());
    }
}
