package com.example.back.vehicule;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RepositoryVehicule extends MongoRepository<Vehicule, String> {
    public List<Vehicule> findVehiculeByModele(String modele);

    public List<Vehicule> findVehiculeByMarque(String marque);
}
