package com.example.back.vehicule;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("vehicule")
public class ControllerVehicule {
    private final ServiceVehicule serviceVehicule;

    public ControllerVehicule(ServiceVehicule serviceVehicule) {
        this.serviceVehicule = serviceVehicule;
    }

    @GetMapping("")
    public List<Vehicule> findAll() {
        return serviceVehicule.findAll();
    }

    @PostMapping("")
    public Vehicule save(@RequestBody Vehicule entity) {
        return serviceVehicule.save(entity);
    }

    @GetMapping("{id}")
    public Vehicule findById(@PathVariable String id) {
        return serviceVehicule.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        serviceVehicule.deleteById(id);
    }

    @PutMapping("{id}")
    public Vehicule update(@PathVariable String id, @RequestBody Vehicule vehicule) {
        return serviceVehicule.update(vehicule, id);
    }

}
