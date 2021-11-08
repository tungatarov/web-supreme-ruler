package com.example.ruler.service;

import com.example.ruler.persistence.dao.LordRepository;
import com.example.ruler.persistence.model.Lord;
import com.example.ruler.persistence.model.Planet;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LordServiceTest {

    private static Lord l1;
    private static Lord l2;
    private static Lord l3;
    private static Lord l4;

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
        l1 = new Lord("L1", 100);
        l2 = new Lord("L2", 200);

        l3 = new Lord("L2", 200);
        l3.setPlanets(Arrays.asList(new Planet("P1", l3), new Planet("P3", l3)));

        l4 = new Lord("L2", 200);
        l4.setPlanets(Arrays.asList(new Planet("P2", l3)));
    }

    @Test
    public void findAllTest_WhenNoRecord() {

        Mockito.when(lordRepository.findAll()).thenReturn(Collections.emptyList());
        assertThat(lordService.findAll().size(), is(0));
        Mockito.verify(lordRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void findAllTest_WhenRecord() {

        Mockito.when(lordRepository.findAll()).thenReturn(Arrays.asList(l1, l2));
        assertThat(lordService.findAll().size(), is(2));
        assertThat(lordService.findAll().get(0), is(l1));
        assertThat(lordService.findAll().get(1),is(l2));
        Mockito.verify(lordRepository, Mockito.times(3)).findAll();

    }

    @Test
    public void findById() {

        Mockito.when(lordRepository.findById(l1.getId())).thenReturn(Optional.of(l1));
        assertThat(lordService.findById(l1.getId()), is(Optional.of(l1)));
        Mockito.verify(lordRepository, Mockito.times(1)).findById(1L);

    }


    @Test
    void createLord() {

        Mockito.when(lordRepository.save(l1)).thenReturn(l1);
        assertThat(lordService.createLord(l1), is(l1));
        Mockito.verify(lordRepository, Mockito.times(1)).save(l1);

        Mockito.when(lordRepository.save(l2)).thenReturn(l2);
        assertThat(lordService.createLord(l2).getName(), is("L2"));
        Mockito.verify(lordRepository, Mockito.times(1)).save(l2);
    }

    @Test
    void findAllLordsWherePlanetsIsNull() {

        Mockito.when(lordRepository.findAllByPlanetsIsNull()).thenReturn(Arrays.asList(l1, l2));
        assertThat(lordService.findAll().size(), is(2));
        assertThat(lordService.findAll().get(0).getPlanets(), is(null));
        assertThat(lordService.findAll().get(1).getPlanets(), is(null));
        Mockito.verify(lordRepository, Mockito.times(3)).findAll();
    }
}