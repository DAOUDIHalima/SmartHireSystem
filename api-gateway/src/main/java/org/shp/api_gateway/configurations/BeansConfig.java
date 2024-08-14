package org.shp.api_gateway.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class BeansConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
