package com.example.dijagnosticki.service;

import com.example.dijagnosticki.model.Izvestaj;
import com.example.dijagnosticki.model.User;

import java.util.List;

public interface IzvestajService {
    List<Izvestaj> listAll();
    Izvestaj findById(Integer id);
    void save(Izvestaj izvestaj);
    List<Izvestaj> findAllByUser (User user);
}
