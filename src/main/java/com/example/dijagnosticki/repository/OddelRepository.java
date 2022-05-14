package com.example.dijagnosticki.repository;


import com.example.dijagnosticki.model.Oddel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OddelRepository extends JpaRepository<Oddel,Integer> {
//    Optional<Oddel> findByOddel_id(Integer oddel_id);
}

