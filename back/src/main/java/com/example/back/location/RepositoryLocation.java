package com.example.back.location;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RepositoryLocation extends MongoRepository<Location, String> {
    public List<Location> findLocationByNom(String nom);

    public List<Location> findLocataireByPrenom(String prenom);
}
