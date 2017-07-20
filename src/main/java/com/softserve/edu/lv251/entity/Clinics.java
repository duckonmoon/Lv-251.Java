package com.softserve.edu.lv251.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 *
 */


@Entity
public class Clinics extends BaseEntity {
    private String clinic_name;

    @Type(type="org.hibernate.type.BinaryType")
    private byte[] photo;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "clinics")
    private List<Doctors> doctors;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.ALL})
    private Contacts contact;

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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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
}
