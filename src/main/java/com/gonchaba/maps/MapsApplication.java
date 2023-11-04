package com.gonchaba.maps;

import com.gonchaba.maps.config.GoogleMapsConfig;
import com.netflix.discovery.EurekaNamespace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(GoogleMapsConfig.class)
@EnableDiscoveryClient
public class MapsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MapsApplication.class, args);
    }
}
