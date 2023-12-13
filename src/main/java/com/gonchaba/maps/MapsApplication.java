package com.gonchaba.maps;

import com.gonchaba.maps.config.GoogleMapsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;

@SpringBootApplication(scanBasePackages = "com.gonchaba.maps", exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableConfigurationProperties(GoogleMapsConfig.class)
@EnableDiscoveryClient
public class MapsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MapsApplication.class, args);
    }

 /*   @Bean
    public OAuth2AuthorizedClientManager clientManager(ClientRegistrationRepository clientRegistrationRepository,
                                                       OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository) {
        OAuth2AuthorizedClientProvider auth2AuthorizedClientProvider
                = OAuth2AuthorizedClientProviderBuilder.builder()
                .clientCredentials()
                .build();
        DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager
                = new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository,
                auth2AuthorizedClientRepository);
        defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(auth2AuthorizedClientProvider);

        return clientManager(clientRegistrationRepository, auth2AuthorizedClientRepository);
    }*/
}
