package com.example.dijagnosticki.service.impl;

import com.example.dijagnosticki.model.Termin;
import com.example.dijagnosticki.model.exceptions.InvalidIdException;
import com.example.dijagnosticki.repository.TerminRepository;
import com.example.dijagnosticki.service.TerminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminServiceImpl implements TerminService {
    private final TerminRepository terminRepository;

    public TerminServiceImpl(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }

    @Override
    public List<Termin> listAll() {
        return this.terminRepository.findAll();
    }

    @Override
    public Termin findById(Integer id) {
        return this.terminRepository.findById(id).orElseThrow(InvalidIdException::new);
    }

    @Override
    public void save(Termin termin) {

        this.terminRepository.save(termin);
    }
}
