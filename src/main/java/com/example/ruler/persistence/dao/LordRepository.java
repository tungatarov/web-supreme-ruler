package com.example.ruler.persistence.dao;

import com.example.ruler.persistence.model.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LordRepository extends JpaRepository<Lord, Long> {
    List<Lord> findAllByPlanetsIsNull();
}
