package com.example.back.locataire;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("locataire")
public class ControllerLocataire {
    private final ServiceLocataire serviceLocataire;

    public ControllerLocataire(ServiceLocataire serviceLocataire) {
        this.serviceLocataire = serviceLocataire;
    }

    @GetMapping("")
    public List<Locataire> findAll() {
        return serviceLocataire.findAll();
    }

    @PostMapping("")
    public Locataire save(@RequestBody Locataire entity) {
        return serviceLocataire.save(entity);
    }

    @GetMapping("{id}")
    public Locataire findById(@PathVariable String id) {
        return serviceLocataire.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        serviceLocataire.deleteById(id);
    }

    @PutMapping("{id}")
    public Locataire update(@PathVariable String id, @RequestBody Locataire locataire) {
        return serviceLocataire.update(locataire, id);
    }
}