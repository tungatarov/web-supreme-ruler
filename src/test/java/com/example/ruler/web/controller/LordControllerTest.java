package com.example.ruler.web.controller;

import com.example.ruler.persistence.dao.LordRepository;
import com.example.ruler.persistence.model.Lord;
import com.example.ruler.service.LordService;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class LordControllerTest {

    private static Lord l1;
    private static Lord l2;

    @Mock
    private LordRepository lordRepository;

    @InjectMocks
    private LordService lordService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        l1 = new Lord("lion", 100);
        l2 = new Lord("rat", 200);
    }

    @Test
    void addLord() {
    }

    @Test
    void getAllLords() {
    }

    @Test
    void appointLordToRulePlanet() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddLord() {
    }

    @Test
    void testGetAllLords() {
    }

    @Test
    void testAppointLordToRulePlanet() {
    }

    @Test
    void getAllLordsWhoDoNotRuleAnyPlanets() {
    }
}