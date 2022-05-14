package com.example.dijagnosticki.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Izvestaj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer izvestaj_id;
    private String opis;
//    @ManyToOne
//    private Patient patient;
    @ManyToOne
    private User user;

}
