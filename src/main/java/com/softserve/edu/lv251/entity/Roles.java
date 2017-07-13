package com.softserve.edu.lv251.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by kilopo on 11.07.2017.
 */
@Entity
public class Roles extends BaseEntity {

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Users> users;

    public Roles() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
