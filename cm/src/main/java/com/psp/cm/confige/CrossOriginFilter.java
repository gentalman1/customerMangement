package com.psp.cm.confige;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CrossOriginFilter implements WebMvcConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrossOriginFilter.class);

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        LOGGER.info(" Cross Origin Filter");
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*");
    }
}
