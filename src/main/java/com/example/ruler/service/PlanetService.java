package com.example.ruler.service;

import com.example.ruler.persistence.dao.PlanetRepository;
import com.example.ruler.persistence.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlanetService {

    private final PlanetRepository planetRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet createPlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    public Optional<Planet> findByName(String name) {
        return planetRepository.findByName(name);
    }

    public Planet save(Planet planet) {
        return planetRepository.save(planet);
    }

    public void deleteById(Long id) {
        planetRepository.deleteById(id);
    }
}
