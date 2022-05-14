package com.example.dijagnosticki.service.impl;

import com.example.dijagnosticki.model.Izvestaj;
import com.example.dijagnosticki.model.User;
import com.example.dijagnosticki.model.exceptions.InvalidIdException;
import com.example.dijagnosticki.repository.IzvestajRepository;
import com.example.dijagnosticki.service.IzvestajService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IzvestajServiceImpl implements IzvestajService {
   private IzvestajRepository izvestajRepository;

    public IzvestajServiceImpl(IzvestajRepository izvestajRepository) {
        this.izvestajRepository = izvestajRepository;
    }

    @Override
    public List<Izvestaj> listAll() {
        return this.izvestajRepository.findAll();
    }

    @Override
    public Izvestaj findById(Integer id) {
        return this.izvestajRepository.findById(id).orElseThrow(InvalidIdException::new);
    }
    @Override
    public void save(Izvestaj izvestaj){
        this.izvestajRepository.save(izvestaj);
    }

    @Override
    public List<Izvestaj> findAllByUser(User user) {
       return this.izvestajRepository.findAllByUser(user);
    }
}
