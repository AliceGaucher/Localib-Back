package com.example.back.locataire;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RepositoryLocataire extends MongoRepository<Locataire, String> {
        public List<Locataire> findLocataireByNom(String nom);

        public List<Locataire> findLocataireByPrenom(String prenom);
}
