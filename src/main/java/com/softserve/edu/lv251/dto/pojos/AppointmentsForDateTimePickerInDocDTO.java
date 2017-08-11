package com.softserve.edu.lv251.dto.pojos;

import java.util.Date;

/**
 * Created by User on 11.08.2017.
 */
public class AppointmentsForDateTimePickerInDocDTO {
    private Date appointmentDate;
    private double duration;
    private long users;

    public AppointmentsForDateTimePickerInDocDTO() {
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public long getUsers() {
        return users;
    }

    public void setUsers(long users) {
        this.users = users;
    }
}
