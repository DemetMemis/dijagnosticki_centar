package com.example.dijagnosticki.repository;


import com.example.dijagnosticki.model.Izvestaj;
import com.example.dijagnosticki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IzvestajRepository extends JpaRepository<Izvestaj,Integer> {
    List<Izvestaj> findAllByUser (User user);
}
