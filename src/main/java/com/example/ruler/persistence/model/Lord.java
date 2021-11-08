package com.example.ruler.persistence.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="lords")
public class Lord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "lord", cascade = CascadeType.ALL)
    private Collection<Planet> planets;

    public Lord() {
    }

    public Lord(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Collection<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Collection<Planet> planets) {
        this.planets = planets;
    }
}
