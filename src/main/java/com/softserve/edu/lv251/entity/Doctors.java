package com.softserve.edu.lv251.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by User on 11.07.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Doctors extends User {

    @Column(length = 10000)
    private String description;
    @JsonIgnore
    @ManyToOne(cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            })
    private Clinic clinic;

    @JsonIgnore
    @OneToMany(mappedBy = "doctors", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Appointment> docAppointments;

    @ManyToOne
    private Specialization specialization;

    public Doctors() {
    }

    public List<Appointment> getDocAppointments() {
        return docAppointments;
    }

    public void setDocAppointments(List<Appointment> docAppointments) {
        this.docAppointments = docAppointments;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }


}
