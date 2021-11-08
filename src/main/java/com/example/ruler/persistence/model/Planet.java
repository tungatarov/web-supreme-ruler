package com.example.ruler.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "lord_id")
    @JsonIgnore
    private Lord lord;

    public Planet() {
    }

    public Planet(String name, Lord lord) {
        this.name = name;
        this.lord = lord;
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

    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }
}
