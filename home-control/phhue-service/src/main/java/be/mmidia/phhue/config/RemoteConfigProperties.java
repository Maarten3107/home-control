package be.mmidia.phhue.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "hue.remote")
public class RemoteConfigProperties {
    private Api api;
    private Authentication authentication;

    public class Api {
        private String url;
    }

    public class Authentication {
        private String userAuthorizationUri;
        private String accessTokenUri;
        private String clientId;
        private String clientSecret;
        private String tokenName;
        private String appId;
        private String deviceId;
        private String state;
        private String callbackUrl;
    }



        /*url: https://api.meethue.com/oauth2/auth
        client-id: y8K6eWB5BSSFXr30IXdVLOOmo3slmYzO
        client-secret: k8x32VzuRF8jmzyd
        app-id: homecontrol
        device-id: toFillIn
        device-name: toFillIn
        state: toFillIn
        callback-url: localhost:8080*/
    //}
}
