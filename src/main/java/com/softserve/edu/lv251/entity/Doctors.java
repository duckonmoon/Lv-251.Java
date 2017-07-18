package com.softserve.edu.lv251.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by User on 11.07.2017.
 */
@Entity
public class Doctors extends BaseEntity {
    @Column(length = 10000)
    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Clinics clinics;

    @OneToMany(mappedBy = "doctors", cascade = {CascadeType.ALL})
    private List<Appointments> docAppointments;

    public Doctors() {
    }

    public List<Appointments> getDocAppointments() {
        return docAppointments;
    }

    public void setDocAppointments(List<Appointments> docAppointments) {
        this.docAppointments = docAppointments;
    }

    public Clinics getClinics() {
        return clinics;
    }

    public void setClinics(Clinics clinics) {
        this.clinics = clinics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
