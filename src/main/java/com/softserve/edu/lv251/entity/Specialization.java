package com.softserve.edu.lv251.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Admin on 21.07.2017.
 */
@Entity
public class Specialization extends BaseEntity {
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "specialization")
    private List<Doctors> doctors;


    public Specialization() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "name='" + name + '\'' +


                '}';
    }
}
