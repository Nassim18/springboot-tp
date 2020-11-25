package fr.umontpellier.fds.m2.springboottp.controllers;

import fr.umontpellier.fds.m2.springboottp.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import fr.umontpellier.fds.m2.springboottp.repositories.LocationRepository;

import java.util.List;

@RestController
public class LocationsController {
    @Autowired
    private LocationRepository locationRepository;
    @GetMapping
    public List<Location> list() {
        return locationRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Location get(@PathVariable Long id) {
        return locationRepository.getOne(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location create(@RequestBody final Location location) {
        return  locationRepository.saveAndFlush(location);
    }

}
