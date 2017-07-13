package com.softserve.edu.lv251.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 *
 */
@Entity
public class Appointments extends BaseEntity {

    private Date appintmentDate;
    private String status;
    private double duration;

    @ManyToOne
    private Doctors doctors;

    @ManyToOne
    private Users users;

    public Appointments() {
    }

    public Doctors getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctors doctors) {
        this.doctors = doctors;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Date getAppintmentDate() {
        return appintmentDate;
    }

    public void setAppintmentDate(Date appintmentDate) {
        this.appintmentDate = appintmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
