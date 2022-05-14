package com.example.dijagnosticki.repository;


import com.example.dijagnosticki.model.Termin;
import com.example.dijagnosticki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminRepository extends JpaRepository<Termin,Integer> {
List<Termin> findTerminByUser(User user);
}
