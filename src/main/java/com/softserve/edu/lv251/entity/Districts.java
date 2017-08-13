package com.softserve.edu.lv251.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Admin on 29.07.2017.
 */
@Entity
public class Districts extends BaseEntity {
    private String name;


    @OneToMany(mappedBy = "district", fetch = FetchType.EAGER)
    private List<Contacts> contacts;


    public Districts() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Districts{" +
                "name='" + name + '\'' +

                '}';
    }
}
