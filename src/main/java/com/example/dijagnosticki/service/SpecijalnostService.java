package com.example.dijagnosticki.service;

import com.example.dijagnosticki.model.Specijalnost;


import java.util.List;
import java.util.Optional;

public interface SpecijalnostService {

    void save (Specijalnost specijalnost);
    List<Specijalnost> findAll();
    Optional<Specijalnost> findById(Integer id);
}
