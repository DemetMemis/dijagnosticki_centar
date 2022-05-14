package com.example.dijagnosticki.model;

import com.example.dijagnosticki.model.enumerations.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Data
@Entity

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer covek_id;
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String embg;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @ManyToOne
    private Specijalnost specijalnost;

    @ManyToOne
    private Oddel oddel;

    @ManyToMany
    private List<Izvestaj> izvestaji;

    public User(String username, String password, String ime, String prezime, String embg, Role role) {

        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.embg = embg;
        this.role = this.role;
        this.specijalnost = specijalnost;
        this.oddel = oddel;
    }

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return   Collections.singletonList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public Integer getCovek_id() {
        return covek_id;
    }
    public String getImePrezime(){
        return ime+" "+prezime;
    }
}
