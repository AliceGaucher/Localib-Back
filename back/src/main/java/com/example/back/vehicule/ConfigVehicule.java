package com.example.back.vehicule;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigVehicule {
    @Configuration
    public class VehiculeConfig {
        @Bean
        public ServiceVehicule serviceVehicule(RepositoryVehicule repositoryVehicule) {
            return new ServiceVehicule(repositoryVehicule);
        }
    }
}
