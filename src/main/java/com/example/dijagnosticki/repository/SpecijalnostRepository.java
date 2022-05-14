package com.example.dijagnosticki.repository;


import com.example.dijagnosticki.model.Specijalnost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecijalnostRepository extends JpaRepository<Specijalnost, Integer> {


}
