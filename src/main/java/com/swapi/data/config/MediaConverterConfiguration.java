package com.swapi.data.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.swapi.data.constants.SwapiConstants;

@Configuration
//@EnableWebMvc
public class MediaConverterConfiguration implements WebMvcConfigurer {
    @Bean
    public MappingJackson2HttpMessageConverter jacksonConverter() {
        MappingJackson2HttpMessageConverter mc =
                new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes =
                new ArrayList<>(mc.getSupportedMediaTypes());
        supportedMediaTypes
                .add(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        supportedMediaTypes.add(
            MediaType.valueOf(SwapiConstants.MEDIA_TYPE_APP_VND));
        mc.setSupportedMediaTypes(supportedMediaTypes);
        return mc;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonConverter());
    }
}
