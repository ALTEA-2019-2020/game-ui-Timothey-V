
package com.miage.altea.game_ui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestConfiguration {

    @Value("${trainer.service.username}")
    String username ;

    @Value("${trainer.service.password}")
    String password ;

    @Bean
    @Primary
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    RestTemplate trainerApiRestTemplate(){
        RestTemplate rt = new RestTemplate() ;
        rt.setInterceptors(List.of((new BasicAuthenticationInterceptor(username,password))));
        return rt;
    }

    @Autowired
    public void configureLocalInterceptor (RestTemplate rt){
        rt.setInterceptors(List.of((httpRequest, bytes, clientHttpRequestExecution) -> {
            httpRequest.getHeaders().add(HttpHeaders.ACCEPT_LANGUAGE, LocaleContextHolder.getLocale().toLanguageTag());
            return clientHttpRequestExecution.execute(httpRequest,bytes);
        }));
    }

}