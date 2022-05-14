package com.example.dijagnosticki.service;

import com.example.dijagnosticki.model.Termin;

import java.util.List;

public interface TerminService {
    List<Termin> listAll();
    Termin findById(Integer id);
    void save (Termin termin);
}
