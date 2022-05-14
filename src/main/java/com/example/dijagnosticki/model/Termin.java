package com.example.dijagnosticki.model;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
@Data
@Entity
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer termin_id;
    private ZonedDateTime termin_vreme ;
    @ManyToOne
    private User user;

    public Termin() {
    }

    public Termin(Integer termin_id, ZonedDateTime termin_vreme, User user) {
        this.termin_id = termin_id;
        this.termin_vreme = termin_vreme;
        this.user = user;
    }

    public Integer getTermin_id() {
        return termin_id;
    }

    public void setTermin_vreme(ZonedDateTime termin_vreme) {
        this.termin_vreme = termin_vreme;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
