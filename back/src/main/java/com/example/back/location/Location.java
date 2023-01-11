package com.example.back.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Location {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String telephone;
    private String immatriculation;
    private String etat;
    private String debut;
    private String fin;
    private String prix;

    private Location(String nom, String prenom, String telephone, String immatriculation, String etat, String debut, String fin, String prix) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.immatriculation = immatriculation;
        this.etat = etat;
        this.debut = debut;
        this.fin = fin;
        this.prix = prix;
    }
}
