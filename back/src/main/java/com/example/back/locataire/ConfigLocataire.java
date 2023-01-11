package com.example.back.locataire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigLocataire {

    @Configuration
    public class LocataireConfig {
        @Bean
        public ServiceLocataire serviceLocataire(RepositoryLocataire repositoryLocataire) {
            return new ServiceLocataire(repositoryLocataire);
        }
    }
}
