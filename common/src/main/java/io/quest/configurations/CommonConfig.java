package io.quest.configurations;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import io.quest.secret.QuestSecretImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.quest")
public class CommonConfig {
    private static final Logger LOGGER = LogManager.getLogger(CommonConfig.class);

    @Value("${azure.keyvaulturl}")
    private String keyVaultUrl;
    @Value("${azure.tenantid}")
    private String azureTenantId;

    @Bean
    public SecretClient secretClient() {
        LOGGER.info("Initializing SCV client. Connecting to {} with tenant {}", keyVaultUrl, azureTenantId);
        return new SecretClientBuilder()
                .vaultUrl(keyVaultUrl)
                .credential(new DefaultAzureCredentialBuilder().tenantId(azureTenantId).build())
                .buildClient();
    }
}