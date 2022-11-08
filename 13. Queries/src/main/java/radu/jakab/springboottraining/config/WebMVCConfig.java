package radu.jakab.springboottraining.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.zalando.problem.jackson.ProblemModule;
import radu.jakab.springboottraining.DeliveryAppProfiles;

import java.util.Arrays;
import java.util.Locale;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:/messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setSupportedLocales(Arrays.asList(new Locale("en"), new Locale("ro")));
        localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }

    @Bean
    @Primary
    @Profile(DeliveryAppProfiles.DEV)
    public ObjectMapper objectMapperDev() {
        return new ObjectMapper()
                .registerModule(new ProblemModule().withStackTraces(true))
                .registerModule(new JavaTimeModule());
    }

    @Bean
    @Primary
    @Profile(DeliveryAppProfiles.PROD)
    public ObjectMapper objectMapperProd() {
        return new ObjectMapper()
                .registerModule(new ProblemModule().withStackTraces(false))
                .registerModule(new JavaTimeModule());
    }
}
