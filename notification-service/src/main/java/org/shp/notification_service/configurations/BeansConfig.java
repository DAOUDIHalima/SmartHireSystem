package org.shp.notification_service.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    // But what if you have a lot of mappers ?
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}