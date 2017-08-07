package com.softserve.edu.lv251.dao;

import com.softserve.edu.lv251.entity.Appointments;

import java.util.List;

/**
 * Created by Taras on 16.07.2017.
 */
public interface AppointmentsDAO extends BaseDAO<Appointments>{
    List<Appointments> getAppiontmentbyDoctorsEmail(String email);

    List<Appointments> getAppointmentByUserEmail(String email);
}
