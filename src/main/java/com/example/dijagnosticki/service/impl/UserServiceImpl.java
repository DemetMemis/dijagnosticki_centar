package com.example.dijagnosticki.service.impl;

import com.example.dijagnosticki.model.User;
import com.example.dijagnosticki.model.enumerations.Role;
import com.example.dijagnosticki.repository.UserRepository;
import com.example.dijagnosticki.service.OddelService;
import com.example.dijagnosticki.service.SpecijalnostService;
import com.example.dijagnosticki.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.dijagnosticki.model.enumerations.Role.ROLE_DOKTOR;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SpecijalnostService specijalnostService;
    private final OddelService oddelService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, SpecijalnostService specijalnostService, OddelService oddelService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.specijalnostService = specijalnostService;
        this.oddelService = oddelService;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return this.userRepository.findById(id);
    }
//
//    @Override
//    public User register(String username, String password, String ime, String prezime, String embg ,Role role, Integer specijalnostId, Integer oddelId) {
//        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
//            throw new InvalidUsernameOrPasswordException();
//
//        if(this.userRepository.findByUsername(username).isPresent())
//            throw new UsernameAlreadyExistsException(username);
//        Specijalnost specijalnost = new Specijalnost();
//        Oddel oddel = new Oddel();
//        specijalnost = this.specijalnostService.findById(specijalnostId).get();
//        oddel = this.oddelService.findByOddelId(oddelId).get();
//        Role role1 = role;
//        if ((role1.toString().equals("ROLE_PACIENT")) || (role1.toString().equals("ROLE_ADMIN"))){
//            specijalnost = null;
//            oddel = null;
//            if (role1.toString().equals("ROLE_ADMIN")){
//                embg = null;
//            }
//        }
//        User user = new User(username, passwordEncoder.encode(password),
//                 ime, prezime,embg, role, specijalnost, oddel);
//        return userRepository.save(user);
//    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

//    @Override
//    public void save(User user) {
//        return this.userRepository.save(user);
//    }

    @Override
    public User register(String username, String password, String ime, String prezime, String embg, Role role) {
        User user = new User(username,passwordEncoder.encode(password),ime,prezime,embg,role);
        user.setRole(Role.valueOf("ROLE_PACIENT"));
        return this.userRepository.save(user);
    }

    @Override
    public List<User> findAllByRole(Role role) {
        return this.userRepository.findAllByRole(role);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
