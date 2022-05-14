package com.example.dijagnosticki.service.impl;

import com.example.dijagnosticki.model.Rezervacija;
import com.example.dijagnosticki.model.exceptions.InvalidIdException;
import com.example.dijagnosticki.repository.RezervacijaRepository;
import com.example.dijagnosticki.service.RezervacijaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezervacijaServiceImpl implements RezervacijaService {
    private final RezervacijaRepository rezervacijaRepository;

    public RezervacijaServiceImpl(RezervacijaRepository rezervacijaRepository) {
        this.rezervacijaRepository = rezervacijaRepository;
    }

    @Override
    public List<Rezervacija> listAll() {
        return this.rezervacijaRepository.findAll();
    }

    @Override
    public Rezervacija findById(Integer id) {
        return this.rezervacijaRepository.findById(id).orElseThrow(InvalidIdException::new);
    }

    @Override
    public void save(Rezervacija rezervacija) {

        this.rezervacijaRepository.save(rezervacija);
    }
}
