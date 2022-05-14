package com.example.dijagnosticki.service;

import com.example.dijagnosticki.model.Rezervacija;

import java.util.List;

public interface RezervacijaService {
    List<Rezervacija> listAll();
    Rezervacija findById(Integer id);
    void save (Rezervacija rezervacija);
}
