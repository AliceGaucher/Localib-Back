package com.example.back.vehicule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class ServiceVehicule {
    private final Logger logger = LoggerFactory.getLogger(ServiceVehicule.class);
    private final RepositoryVehicule repositoryVehicule;

    public ServiceVehicule(RepositoryVehicule repositoryVehicule) {
        this.repositoryVehicule = repositoryVehicule;
    }

    /**
     * Permet de trouver tout les vehicules de la base de données
     * @return
     */
    public List<Vehicule> findAll() {
        return repositoryVehicule.findAll();
    }

    /**
     * Créer un vehicule dans la base de données
     * @param entity
     * @return
     */
    public Vehicule save(Vehicule entity) {
        logger.info("Le vehicule a bien été crée : " + entity.toString());
        return repositoryVehicule.save(entity);
    }

    /**
     * Trouve et renvoi un vehicule via son id
     * @param id
     * @return
     */
    public Vehicule findById(String id) {
        return repositoryVehicule.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    /**
     * Met à jour un vehicule via son id
     * @param vehicule
     * @param id
     * @return
     */
    public Vehicule update(Vehicule vehicule, String id) {
        Vehicule vehiculeFromDB = this.findById(id);
        if(vehiculeFromDB != null) {
            vehiculeFromDB.setMarque(vehicule.getMarque());
            vehiculeFromDB.setModele(vehicule.getModele());
            vehiculeFromDB.setEtat(vehicule.getEtat());
            vehiculeFromDB.setPrix(vehicule.getPrix());
            vehiculeFromDB.setDisponibilite(vehicule.getDisponibilite());
            vehiculeFromDB.setType(vehicule.getType());
        }
        return this.save(vehiculeFromDB);
    }

    /**
     * Supprimer un vehicule via son id
     * @param id
     */
    public void deleteById(String id) {
        repositoryVehicule.deleteById(id);
    }

    /**
     * Supprimer tout les vehicules
     */
    public void deleteAll() {
        this.repositoryVehicule.deleteAll();
    }

}
