package com.example.ruler.service;

import com.example.ruler.persistence.dao.LordRepository;
import com.example.ruler.persistence.dao.PlanetRepository;
import com.example.ruler.persistence.model.Lord;
import com.example.ruler.persistence.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LordService {

    private final LordRepository lordRepository;
    private final PlanetRepository planetRepository;

    @Autowired
    public LordService(LordRepository lordRepository, PlanetRepository planetRepository) {
        this.lordRepository = lordRepository;
        this.planetRepository = planetRepository;
    }

    public Lord createLord(Lord lord) {
        return lordRepository.save(lord);
    }

    public Optional<Lord> findById(Long id) {
        return lordRepository.findById(id);
    }

    public List<Lord> findAll() {
        return lordRepository.findAll();
    }

    public List<Lord> findAllLordsWherePlanetsIsNull() {
        return lordRepository.findAllByPlanetsIsNull();
    }
}
