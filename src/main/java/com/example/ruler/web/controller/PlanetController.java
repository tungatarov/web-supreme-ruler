package com.example.ruler.web.controller;

import com.example.ruler.persistence.dao.PlanetRepository;
import com.example.ruler.persistence.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/planets")
@Component
public class PlanetController {

    private final PlanetRepository planetRepository;

    @Autowired
    public PlanetController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @PostMapping
    public Planet createPlanet(@RequestBody Planet planet) {
        return planetRepository.save(planet);
    }

    @GetMapping
    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    @DeleteMapping
    public ResponseEntity<String> deletePlanet(Planet planet) {
        planetRepository.delete(planet);
        return ResponseEntity.noContent().build();
    }
}
