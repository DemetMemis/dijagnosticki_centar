package com.example.dijagnosticki.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Oddel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oddel_id;
    private String naziv;
}
