package com.example.back.locataire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceLocataire {
    private final Logger logger = LoggerFactory.getLogger(ServiceLocataire.class);
    private final RepositoryLocataire repositoryLocataire;

    public ServiceLocataire(RepositoryLocataire repositoryLocataire) {
        this.repositoryLocataire = repositoryLocataire;
    }

    /**
     * Permet de trouver tout les locataires de la base de données
     * @return
     */
    public List<Locataire> findAll() {
        return repositoryLocataire.findAll();
    }

    /**
     * Créer un locataire dans la base de données
     * @param entity
     * @return
     */
    public Locataire save(Locataire entity) {
        logger.info("Le locataire a bien été crée : " + entity.toString());
        return repositoryLocataire.save(entity);
    }

    /**
     * Trouve et renvoi un locataire via son id
     * @param id
     * @return
     */
    public Locataire findById(String id) {
        return repositoryLocataire.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    /**
     * Met à jour un locataire via son id
     * @param locataire
     * @param id
     * @return
     */
    public Locataire update(Locataire locataire, String id) {
        Locataire locataireFromDB = this.findById(id);
        if(locataireFromDB != null) {
            locataireFromDB.setEmail(locataire.getEmail());
            locataireFromDB.setNom(locataire.getNom());
            locataireFromDB.setPrenom(locataire.getPrenom());
            locataireFromDB.setNaissane(locataire.getNaissane());
            locataireFromDB.setTelephone(locataire.getTelephone());
        }
        return this.save(locataireFromDB);
    }

    /**
     * Supprimer un locataire via son id
     * @param id
     */
    public void deleteById(String id) {
        repositoryLocataire.deleteById(id);
    }

    /**
     * Supprimer tout les locataires
     */
    public void deleteAll() {
        this.repositoryLocataire.deleteAll();
    }

}
