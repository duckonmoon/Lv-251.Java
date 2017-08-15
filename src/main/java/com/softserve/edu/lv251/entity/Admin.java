package com.softserve.edu.lv251.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

/**
 * Created by Shmidt on 15.08.2017.
 */
@Entity
public class Admin extends Users {

    @OneToMany
    private List<Moderator> moderators;

    public Admin() {
    }

    public List<Moderator> getModerators() {
        return moderators;
    }

    public void setModerators(List<Moderator> moderators) {
        this.moderators = moderators;
    }
}
