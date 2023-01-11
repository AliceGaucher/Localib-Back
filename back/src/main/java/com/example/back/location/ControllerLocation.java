package com.example.back.location;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("location")
public class ControllerLocation {
    private final ServiceLocation serviceLocation;

    public ControllerLocation(ServiceLocation serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    @GetMapping("")
    public List<Location> findAll() {
        return serviceLocation.findAll();
    }

    @PostMapping("")
    public Location save(@RequestBody Location entity) {
        return serviceLocation.save(entity);
    }

    @GetMapping("{id}")
    public Location findById(@PathVariable String id) {
        return serviceLocation.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        serviceLocation.deleteById(id);
    }

    @PutMapping("{id}")
    public Location update(@PathVariable String id, @RequestBody Location location) {
        return serviceLocation.update(location, id);
    }
}
