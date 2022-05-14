package com.example.dijagnosticki.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rezervacija_id;
    @OneToOne
  private Termin termin;
    @ManyToOne
    private User user;

}
