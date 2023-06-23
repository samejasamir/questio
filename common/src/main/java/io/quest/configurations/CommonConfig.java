package io.quest.configurations;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.quest")
public class CommonConfig {
    @Value("${azure.keyvaulturl}")
    private String keyVaultUrl;
    @Value("${azure.tenantid}")
    private String azureTenantId;

    @Bean
    public SecretClient secretClient()
    {
        return new SecretClientBuilder()
                .vaultUrl(keyVaultUrl)
                .credential(new DefaultAzureCredentialBuilder().tenantId(azureTenantId).build())
                .buildClient();
    }
}