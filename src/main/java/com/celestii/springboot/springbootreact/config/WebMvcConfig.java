package com.celestii.springboot.springbootreact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(this.mappingJackson2HttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(new CustomObjectMapper());
        return jsonConverter;
    }

    //string <-> object로 변환해서 Databinding
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(this.localDateFormatter());
    }

    @Bean
    public Formatter<LocalDate> localDateFormatter() {
        return new Formatter<>() {
            @Override
            public LocalDate parse(String text, Locale locale) throws ParseException {
                return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

            @Override
            public String print(LocalDate object, Locale locale) {
                return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
            }
        };
    }

    @Bean
    public Formatter<YearMonth> yearMonthFormatter() {
        return new Formatter<>() {
            @Override
            public YearMonth parse(String text, Locale locale) throws ParseException {
                return YearMonth.parse(text, DateTimeFormatter.ofPattern("yyyy-MM"));
            }

            @Override
            public String print(YearMonth object, Locale locale) {
                return DateTimeFormatter.ofPattern("yyyy-MM").format(object);
            }
        };
    }

    @Bean
    public Formatter<LocalDateTime> localDateTimeFormatter() {
        return new Formatter<>() {
            @Override
            public LocalDateTime parse(String text, Locale locale) throws ParseException {
                return LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }

            @Override
            public String print(LocalDateTime object, Locale locale) {
                return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(object);
            }
        };
    }

    @Bean
    public Formatter<LocalTime> localTimeFormatter() {
        return new Formatter<>() {
            @Override
            public LocalTime parse(String text, Locale locale) throws ParseException {
                return LocalTime.parse(text, DateTimeFormatter.ofPattern("HH:mm:ss"));
            }

            @Override
            public String print(LocalTime object, Locale locale) {
                return DateTimeFormatter.ofPattern("HH:mm:ss").format(object);
            }
        };
    }
}
