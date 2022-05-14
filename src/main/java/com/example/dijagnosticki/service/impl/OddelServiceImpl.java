package com.example.dijagnosticki.service.impl;

import com.example.dijagnosticki.model.Oddel;
import com.example.dijagnosticki.model.exceptions.InvalidIdException;
import com.example.dijagnosticki.repository.OddelRepository;
import com.example.dijagnosticki.service.OddelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OddelServiceImpl implements OddelService {
    private OddelRepository oddelRepository;

    public OddelServiceImpl(OddelRepository oddelRepository) {
        this.oddelRepository = oddelRepository;
    }

    @Override
    public List<Oddel> listAll() {
        return this.oddelRepository.findAll();
    }

    @Override
    public Oddel findById(Integer id) {
        return this.oddelRepository.findById(id).orElseThrow(InvalidIdException::new);
    }

//    @Override
//    public Optional<Oddel> findByOddelId(Integer oddel_id) {
//        return this.oddelRepository.findByOddel_id(oddel_id);
//    }

//    @Override
//    public Oddel save(String naziv, Integer bolnica_id, Integer specijalnost_id) {
//        Bolnica bolnica = this.bolnicaRepository.findById(bolnica_id).get();
//        Specijalnost specijalnost = this.specijalnostRepository.findById(specijalnost_id).get();
//
//        Oddel oddel = new Oddel(naziv, bolnica, specijalnost);
//
//        return oddelRepository.save(oddel);
//    }
}
