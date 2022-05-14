package com.example.dijagnosticki.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Specijalnost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spec_id;
    private String naziv;

    public Specijalnost() {
    }

    public Specijalnost(String naziv) {

        this.naziv = naziv;
    }
}
