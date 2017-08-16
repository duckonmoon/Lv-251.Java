package com.softserve.edu.lv251.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Admin on 31.07.2017.
 */
@Entity
public class Moderator extends User {

    @OneToOne
    private Clinics clinic;

    @ManyToOne
    Admin admin;

    public Moderator() {
    }

    public Clinics getClinics() {
        return clinic;
    }

    public void setClinics(Clinics clinics) {
        this.clinic = clinics;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
