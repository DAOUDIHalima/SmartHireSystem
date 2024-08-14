package org.shp.application_service.configurations;

import org.modelmapper.ModelMapper;
import org.shp.application_service.services.facade.ApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
