package com.example.back.vehicule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Vehicule {
    @Id
    private String id;
    private String marque;
    private String modele;
    private String immatriculation;
    private String etat;
    private String prix;
    private String disponibilite;
    private String type;

    private Vehicule (String marque, String modele, String immatriculation, String etat, String prix, String disponibilite, String type) {
        this.marque = marque;
        this.modele = modele;
        this.immatriculation = immatriculation;
        this.etat = etat;
        this.prix = prix;
        this.disponibilite = disponibilite;
        this.type = type;
    }
}
