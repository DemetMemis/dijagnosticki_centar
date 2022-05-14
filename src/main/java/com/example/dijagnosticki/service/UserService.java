package com.example.dijagnosticki.service;

import com.example.dijagnosticki.model.User;
import com.example.dijagnosticki.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    Optional<User> findById (Integer id);
//    User register (String username, String password, String embg,
//                   String ime, String prezime, Role role, Integer specijalnostId, Integer oddelId);

    Optional<User> findByUsername (String username);
//    void save(User user);
    User register (String username, String password, String ime, String prezime, String embg, Role role);
    List<User> findAllByRole(Role role);

    void save(User user);
}
