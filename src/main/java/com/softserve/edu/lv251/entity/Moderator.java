package com.softserve.edu.lv251.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by Admin on 31.07.2017.
 */
@Entity
public class Moderator extends Users{
    @OneToOne
    private Clinics clinic;

    public Moderator() {
    }

    public Clinics getClinics() {
        return clinic;
    }

    public void setClinics(Clinics clinics) {
        this.clinic = clinics;
    }
}
