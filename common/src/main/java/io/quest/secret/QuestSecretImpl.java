package io.quest.secret;

import com.azure.security.keyvault.secrets.SecretClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class QuestSecretImpl implements QuestSecret{
    private static final Logger LOGGER = LogManager.getLogger(QuestSecretImpl.class);

    private final SecretClient secretClient;

    public QuestSecretImpl(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    @Override
    public String GetSecretByName(String name) {
        LOGGER.info("Getting secret {}", name);
        return secretClient.getSecret(name).getValue();
    }
}
