package br.com.uol.intranet.jira.api.config;

import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;


@Configuration
public class WebClientConfig {

    @Value("${api.key.token}")
    private String token;

    @Value("${api.jira.url}")
    private String url;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {

        HttpClient httpClient = HttpClient.create()
                .secure(t -> {
                    try {
                        t.sslContext(SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build());
                    } catch (SSLException e) {
                        throw new RuntimeException(e);
                    }
                });

        return builder
                .baseUrl(url)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, token)
                .build();
    }
}
