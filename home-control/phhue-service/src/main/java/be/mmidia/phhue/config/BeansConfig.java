package be.mmidia.phhue.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfig {
    @Bean
    @ConfigurationProperties("hue.remote.authentication")
    public AuthorizationCodeResourceDetails hueRemote() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("hue.remote.api")
    public ResourceServerProperties hueRemoteResource() {
        return new ResourceServerProperties();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
