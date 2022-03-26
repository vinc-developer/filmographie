package com.film.tdfilmographie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class config {

    @Bean
    public ClassLoaderTemplateResolver primaryTemplateResolver() {

        ClassLoaderTemplateResolver primaryTemplateResolver = new ClassLoaderTemplateResolver();

        primaryTemplateResolver.setPrefix("templates/");
        primaryTemplateResolver.setSuffix(".html");
        primaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
        primaryTemplateResolver.setCharacterEncoding("UTF-8");
        primaryTemplateResolver.setOrder(1);
        primaryTemplateResolver.setCheckExistence(true);

        return primaryTemplateResolver;

    }
}
