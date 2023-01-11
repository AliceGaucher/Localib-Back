package com.example.back.locataire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document

public class Locataire {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String naissane;
    private String email;
    private String telephone;

    private Locataire(String nom, String prenom, String naissane, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissane = naissane;
        this.telephone = telephone;
    }
}