package com.example.dijagnosticki.web;

import com.example.dijagnosticki.model.User;
import com.example.dijagnosticki.model.enumerations.Role;
import com.example.dijagnosticki.model.exceptions.InvalidArgumentsException;
import com.example.dijagnosticki.service.*;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
private final UserService userService;
private final IzvestajService izvestajService;
private final OddelService oddelService;
private final RezervacijaService rezervacijaService;
private final TerminService terminService;
private final SpecijalnostService specijalnostService;

    public Controller(UserService userService, IzvestajService izvestajService, OddelService oddelService, RezervacijaService rezervacijaService, TerminService terminService, SpecijalnostService specijalnostService) {
        this.userService = userService;
        this.izvestajService = izvestajService;
        this.oddelService = oddelService;
        this.rezervacijaService = rezervacijaService;
        this.terminService = terminService;
        this.specijalnostService = specijalnostService;
    }


    @GetMapping({"/","/home"})
    public String home(){

        return "index.html";
    }
    @GetMapping("/home-logged")
    public String homelogged(){

        return "index-loggeduser.html";
    }


}
