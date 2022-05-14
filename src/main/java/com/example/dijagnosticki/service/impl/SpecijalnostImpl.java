package com.example.dijagnosticki.service.impl;


import com.example.dijagnosticki.model.Specijalnost;
import com.example.dijagnosticki.repository.SpecijalnostRepository;
import com.example.dijagnosticki.service.SpecijalnostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecijalnostImpl implements SpecijalnostService {

    private final SpecijalnostRepository specijalnostRepository;

    public SpecijalnostImpl(SpecijalnostRepository specijalnostRepository) {
        this.specijalnostRepository = specijalnostRepository;
    }

    @Override
    public void save(Specijalnost specijalnost) {
        this.specijalnostRepository.save(specijalnost);
    }

    @Override
    public List<Specijalnost> findAll() {
        return this.specijalnostRepository.findAll();
    }

    @Override
    public Optional<Specijalnost> findById(Integer id) {
        return this.specijalnostRepository.findById(id);
    }
}
