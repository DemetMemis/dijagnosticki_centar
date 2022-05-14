package com.example.dijagnosticki.web;

import com.example.dijagnosticki.model.Oddel;
import com.example.dijagnosticki.model.Specijalnost;
import com.example.dijagnosticki.model.enumerations.Role;
import com.example.dijagnosticki.model.exceptions.InvalidArgumentsException;
import com.example.dijagnosticki.service.OddelService;
import com.example.dijagnosticki.service.SpecijalnostService;
import com.example.dijagnosticki.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;
    private final SpecijalnostService specijalnostService;
    private final OddelService oddelService;

    public RegisterController(UserService userService, SpecijalnostService specijalnostService, OddelService oddelService) {
        this.userService = userService;
        this.specijalnostService = specijalnostService;
        this.oddelService = oddelService;
    }
    @GetMapping
    public String getRegisterPage( Model model) {

        List<Specijalnost> specijalnostList = this.specijalnostService.findAll();
        List<Oddel> oddelList = this.oddelService.listAll();
        model.addAttribute("specijalnostList", specijalnostList);
        model.addAttribute("oddelList", oddelList);
        model.addAttribute("bodyContent", "specijalnostList");
        model.addAttribute("bodyContent", "oddelList");
        model.addAttribute("bodyContent","register");
        return "register1.html";
    }
    @PostMapping
    public String register(
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String ime,
                           @RequestParam String prezime ,
                           @RequestParam String embg,
                           @RequestParam Role role
                           ) {

        this.userService.register(username, password, ime, prezime,embg,  role);
            return "redirect:/login";}
}
