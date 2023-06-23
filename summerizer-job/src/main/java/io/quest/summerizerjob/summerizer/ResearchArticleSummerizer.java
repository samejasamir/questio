package io.quest.summerizerjob.summerizer;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import io.quest.model.Article;
import io.quest.repository.ArticleRepo;
import io.quest.secret.QuestSecret;
import io.quest.secret.QuestSecretKeyEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchArticleSummerizer implements ArticleSummerizer {
    private static final Logger LOG = LogManager.getLogger(ResearchArticleSummerizer.class);
    private final ArticleRepo articleRepo;
    private final QuestSecret questSecret;

    public ResearchArticleSummerizer(ArticleRepo articleRepo, QuestSecret questSecret) {
        this.articleRepo = articleRepo;
        this.questSecret = questSecret;
    }

    @Override
    public void Summerize() {
        List<Article> articles = articleRepo.GetAllArticles();
        articles.forEach(article -> GenerateSummary(article));
        articleRepo.UpdateArticles(articles);
    }

    private void GenerateSummary(Article article) {
        OpenAiService service = new OpenAiService(questSecret.GetSecretByName(QuestSecretKeyEnum.QUESTIO_SUMMARY_OPENAI_KEY.label));
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(article.getArticleRaw() + questSecret.GetSecretByName(QuestSecretKeyEnum.QUESTIO_SUMMARY_ALGO.label))
                .model(questSecret.GetSecretByName(QuestSecretKeyEnum.QUESTIO_SUMMARY_MODEL.label))
                .temperature(Double.parseDouble(questSecret.GetSecretByName(QuestSecretKeyEnum.QUESTIO_SUMMARY_TEMP.label)))
                .maxTokens(Integer.parseInt(questSecret.GetSecretByName(QuestSecretKeyEnum.QUESTIO_SUMMARY_MAX_TOKENS.label)))
                .topP(Double.parseDouble(questSecret.GetSecretByName(QuestSecretKeyEnum.QUESTIO_SUMMARY_TOPP.label)))
                .frequencyPenalty(Double.parseDouble(questSecret.GetSecretByName(QuestSecretKeyEnum.QUESTIO_SUMMARY_FP.label)))
                .presencePenalty(Double.parseDouble(questSecret.GetSecretByName(QuestSecretKeyEnum.QUESTIO_SUMMARY_PP.label)))
                .build();
        var choices = service.createCompletion(completionRequest).getChoices();
        article.setArticleSummary(choices.get(0).getText());
    }
}
