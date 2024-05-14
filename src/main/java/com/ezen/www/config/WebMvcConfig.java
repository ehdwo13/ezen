package com.ezen.www.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {
    String uploadPath = "file:////home/dongjae/문서/_myProject/_java/_fileUpload//";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/upload/**").addResourceLocations(uploadPath);
    }
}
