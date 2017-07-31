package com.softserve.edu.lv251.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 *
 */


@Entity
public class Clinics extends BaseEntity {
    private String clinic_name;

    @Column(name = "photo", nullable = false, length = 65535, columnDefinition="TEXT")
    private String photo;

    private String description;


    @OneToMany(mappedBy = "clinics")
    @JsonIgnore
    private List<Doctors> doctors;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.ALL})
    private Contacts contact;
    @JsonIgnore
    @OneToOne(mappedBy = "clinic")
    private Moderator moderator;

    public Clinics() {
    }

    public Contacts getContact() {
        return contact;
    }

    public void setContact(Contacts contacts) {
        this.contact = contacts;
    }

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Moderator getModerator() {
        return moderator;
    }

    public void setModerator(Moderator moderator) {
        this.moderator = moderator;
    }

    @Override
    public String toString() {
        return "Clinics{" +
                "clinic_name='" + clinic_name + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +

                '}';
    }
}
