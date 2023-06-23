package io.quest.secret;

public enum QuestSecretKeyEnum {
    QUESTIO_SUMMARY_ALGO("questio-summary-algo"),
    QUESTIO_SUMMARY_FP("questio-summary-fp"),
    QUESTIO_SUMMARY_MAX_TOKENS("questio-summary-max-tokens"),
    QUESTIO_SUMMARY_MODEL("questio-summary-model"),
    QUESTIO_SUMMARY_OPENAI_KEY("questio-summary-openai-key"),
    QUESTIO_SUMMARY_PP("questio-summary-pp"),
    QUESTIO_SUMMARY_TEMP("questio-summary-temperature"),
    QUESTIO_SUMMARY_TOPP("questio-summary-topp");

    public final String label;
    QuestSecretKeyEnum(String label) {
        this.label = label;
    }
}
