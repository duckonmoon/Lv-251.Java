package com.softserve.edu.lv251.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kilopo on 11.07.2017.
 */
@Entity
public class Roles extends BaseEntity {

    @Column
    private String name;

    /*@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)*/
    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Users.class)
    @JoinTable(
            name = "roles_users",
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
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
