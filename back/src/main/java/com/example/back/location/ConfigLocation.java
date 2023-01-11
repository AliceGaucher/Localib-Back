package com.example.back.location;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigLocation {

    @Configuration
    public class LocationConfig {
        @Bean
        public ServiceLocation serviceLocation(RepositoryLocation repositoryLocation) {
            return new ServiceLocation(repositoryLocation);
        }
    }
}
