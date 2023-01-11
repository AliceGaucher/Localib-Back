package com.example.back.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class ServiceLocation {
    private final Logger logger = LoggerFactory.getLogger(ServiceLocation.class);
    private final RepositoryLocation repositoryLocation;

    public ServiceLocation(RepositoryLocation repositoryLocation) {
        this.repositoryLocation = repositoryLocation;
    }

    /**
     * Permet de trouver toutes les locations de la base de données
     * @return
     */
    public List<Location> findAll() {
        return repositoryLocation.findAll();
    }

    /**
     * Créer un locataire dans la base de données
     * @param entity
     * @return
     */
    public Location save(Location entity) {
        logger.info("La location a bien été créée : " + entity.toString());
        return repositoryLocation.save(entity);
    }

    /**
     * Trouve et renvoi une location via son id
     * @param id
     * @return
     */
    public Location findById(String id) {
        return repositoryLocation.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    /**
     * Met à jour une location via son id
     * @param location
     * @param id
     * @return
     */
    public Location update(Location location, String id) {
        Location locationFromDB = this.findById(id);
        if(locationFromDB != null) {
            locationFromDB.setNom(location.getNom());
            locationFromDB.setPrenom(location.getPrenom());
            locationFromDB.setTelephone(location.getTelephone());
            locationFromDB.setEtat(location.getEtat());
            locationFromDB.setDebut(location.getDebut());
            locationFromDB.setFin(location.getFin());
            locationFromDB.setImmatriculation(location.getImmatriculation());
            locationFromDB.setPrix(location.getPrix());
        }
        return this.save(locationFromDB);
    }

    /**
     * Supprimer un locataire via son id
     * @param id
     */
    public void deleteById(String id) {
        repositoryLocation.deleteById(id);
    }

    /**
     * Supprimer tout les locataires
     */
    public void deleteAll() {
        this.repositoryLocation.deleteAll();
    }
}
