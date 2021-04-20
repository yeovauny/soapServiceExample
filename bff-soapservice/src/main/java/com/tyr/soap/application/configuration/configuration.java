package com.tyr.soap.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class configuration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.tyr.soap.application.domain.generated");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate meth(){
        WebServiceTemplate template = new WebServiceTemplate(marshaller());
        return template;
    }



}
