package com.example.dijagnosticki.web;

import com.example.dijagnosticki.model.Izvestaj;
import com.example.dijagnosticki.model.Termin;
import com.example.dijagnosticki.model.User;
import com.example.dijagnosticki.service.IzvestajService;
import com.example.dijagnosticki.service.TerminService;
import com.example.dijagnosticki.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class DoctorController {
    private final UserService userService;
    private final TerminService terminService;
    private final IzvestajService izvestajService;

    public DoctorController(UserService userService, TerminService terminService, IzvestajService izvestajService) {
        this.userService = userService;
        this.terminService = terminService;
        this.izvestajService = izvestajService;
    }
    @GetMapping("/vnesi-termin/")
    public String getEditTerminPage ( Model model) {
//        User user = this.userService.findById(id).get();
        model.addAttribute("termin", new Termin());
        return "vnesi-nov.html";
    }
    @PostMapping("/save-termin")
    @Transactional
    public String saveTermin (Model model, HttpServletRequest request,
                              @RequestParam(value = "vreme") String vreme){
        User user = this.userService.findByUsername(request.getRemoteUser()).get();
        Termin termin = new Termin();
        termin.setUser(user);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime vremeZ = LocalDateTime.parse(vreme, DateTimeFormatter.ISO_DATE_TIME).atZone(zoneId);
        termin.setTermin_vreme(vremeZ);
        model.addAttribute("termin", termin);
        this.terminService.save(termin);
        return "nov-termin.html";
    }
    @GetMapping("/vnesi-izvestaj")
    public String vnesiIzvestaj (Izvestaj izvestaj ,Model model){

        return "izvestaj";
    }
    @PostMapping("/save-izvestaj")
    public String register(Izvestaj izvestaj, Model model,HttpServletRequest request){
        model.addAttribute("izvestaj", izvestaj);
        User user = this.userService.findByUsername(request.getRemoteUser()).get();
        izvestaj.setUser(user);
        this.izvestajService.save(izvestaj);
        return "redirect:/home-logged";
    }
}
