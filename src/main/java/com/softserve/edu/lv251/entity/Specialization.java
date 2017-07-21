package com.softserve.edu.lv251.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by Admin on 21.07.2017.
 */
@Entity
public class Specialization extends BaseEntity {
private  String name;
private  String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
