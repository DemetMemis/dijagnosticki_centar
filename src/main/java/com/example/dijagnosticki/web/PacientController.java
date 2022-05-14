package com.example.dijagnosticki.web;

import com.example.dijagnosticki.model.*;
import com.example.dijagnosticki.model.enumerations.Role;
import com.example.dijagnosticki.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PacientController {
    private final UserService userService;
    private final TerminService terminService;
    private final SpecijalnostService specijalnostService;
    private final OddelService oddelService;
    private final RezervacijaService rezervacijaService;
    private final IzvestajService izvestajService;

    public PacientController(UserService userService, TerminService terminService, SpecijalnostService specijalnostService, OddelService oddelService, RezervacijaService rezervacijaService, IzvestajService izvestajService) {
        this.userService = userService;
        this.terminService = terminService;
        this.specijalnostService = specijalnostService;
        this.oddelService = oddelService;
        this.rezervacijaService = rezervacijaService;
        this.izvestajService = izvestajService;
    }

    @GetMapping("/zakazi-termin")
    public String showProducts( Model model,Termin termin) {

        List<Termin> termins = this.terminService.listAll();
        List<Specijalnost> specijalnosts=this.specijalnostService.findAll();
        List<Oddel> oddels=this.oddelService.listAll();
        List<User> users=this.userService.findAllByRole(Role.ROLE_DOKTOR);
        model.addAttribute("specijalnosts",specijalnosts);
        model.addAttribute("oddels",oddels);
        model.addAttribute("termins", termins);
        model.addAttribute("users",users);

        return "zakazi";
    }
    @PostMapping("/rezervacija/{termin_id}")
    public String rezerviraj( @PathVariable Integer termin_id ,Model model, HttpServletRequest request){
        Termin termin=this.terminService.findById(termin_id);
        User user= this.userService.findByUsername(request.getRemoteUser()).get();
        Rezervacija rezervacija=new Rezervacija();
        rezervacija.setUser(user);
        rezervacija.setTermin(termin);

        this.rezervacijaService.save(rezervacija);
        return "redirect:/home-logged";
    }
   @GetMapping("/moi-izvestaji")
    public String izvestaji(Model model,HttpServletRequest request){
       User user= this.userService.findByUsername(request.getRemoteUser()).get();
       List<Izvestaj> izvestajs=izvestajService.findAllByUser(user);
       model.addAttribute("izvestaji",izvestajs);
       return "moi-izvestaji";

   }
}
