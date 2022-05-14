package com.example.dijagnosticki.service;

import com.example.dijagnosticki.model.Oddel;

import java.util.List;
import java.util.Optional;

public interface OddelService {
    List<Oddel> listAll();
    Oddel findById(Integer id);
//    Optional<Oddel> findByOddelId(Integer oddel_id);
//    Oddel save (String naziv, Integer bolnica_id, Integer specijalnost_id);
}
