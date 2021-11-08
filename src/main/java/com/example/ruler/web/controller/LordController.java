package com.example.ruler.web.controller;

import com.example.ruler.persistence.model.Lord;
import com.example.ruler.persistence.model.Planet;
import com.example.ruler.service.LordService;
import com.example.ruler.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/lords")
@Component
public class LordController {

    private final LordService lordService;
    private final PlanetService planetService;

    @Autowired
    public LordController(LordService lordService, PlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @PostMapping
    public Lord addLord(@RequestBody Lord lord) {
        return lordService.createLord(lord);
    }

    @GetMapping
    public List<Lord> getAllLords() {
        return lordService.findAll();
    }

    @PostMapping("/{id}/appoint/{name}")
    public ResponseEntity<?> appointLordToRulePlanet(@PathVariable("id") Long lordId,
                                                  @PathVariable("name") String planetName) {

        Optional<Lord> existingLord = lordService.findById(lordId);
        if (existingLord.isEmpty()) {
            return new ResponseEntity<Lord>(HttpStatus.NOT_FOUND);
        }

        Optional<Planet> existingPlanet = planetService.findByName(planetName);
        if (existingPlanet.isEmpty()) {
            return new ResponseEntity<Planet>(HttpStatus.NOT_FOUND);
        }

        Planet planet = existingPlanet.get();
        Lord lord = existingLord.get();
        planet.setLord(lord);
        Planet updatedPlanet = planetService.save(planet);

        if (updatedPlanet.getLord().equals(lord)) {
            return new ResponseEntity<>(lord, HttpStatus.OK);

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/idlers")
    public List<Lord> getAllLordsWhoDoNotRuleAnyPlanets() {
        return lordService.findAllLordsWherePlanetsIsNull();
    }
}


