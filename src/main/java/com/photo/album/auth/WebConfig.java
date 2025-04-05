package com.photo.album.auth;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to /api/* paths
                .allowedOrigins("https://photo-album-frontend-mgondocs-dev.apps.rm3.7wse.p1.openshiftapps.com") // Allow the frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow HTTP methods
                .allowedHeaders("*"); // Allow any headers
    }
}
