package com.softserve.edu.lv251.entity;

import javax.persistence.OneToMany;

/**
 * Created by Shmidt on 13.08.2017.
 */
public class Admin extends Users {

    @OneToMany
    Clinics clinics;
    Moderator moderator;
}
