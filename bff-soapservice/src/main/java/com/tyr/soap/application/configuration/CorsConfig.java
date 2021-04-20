package com.tyr.soap.application.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;
import java.util.stream.Stream;
import io.swagger.models.HttpMethod;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CorsConfig {

    private static final String ALLOWED_HEADER = "*";

    private static final String PATTERN = "/**";

    @Value("${cors.allowedOrigins}")
    private String[] allowedOrigins;


    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        Stream<String> originStream = Arrays.stream(allowedOrigins);
        originStream.forEach(config::addAllowedOrigin);

        config.addAllowedHeader(ALLOWED_HEADER);

        config.addAllowedMethod(HttpMethod.OPTIONS.toString());
        config.addAllowedMethod(HttpMethod.GET.toString());
        config.addAllowedMethod(HttpMethod.POST.toString());
        config.addAllowedMethod(HttpMethod.PUT.toString());
        config.addAllowedMethod(HttpMethod.DELETE.toString());
        config.addAllowedHeader(HttpMethod.PATCH.toString());

        source.registerCorsConfiguration(PATTERN, config);
        return new CorsFilter(source);

    }

    @Bean
    public HttpMessageConverters customConverters() {
        ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        return new HttpMessageConverters(arrayHttpMessageConverter);
    }


}
