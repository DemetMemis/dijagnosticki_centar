package com.example.dijagnosticki.repository;


import com.example.dijagnosticki.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija,Integer> {
}
