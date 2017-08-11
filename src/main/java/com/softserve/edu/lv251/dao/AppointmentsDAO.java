package com.softserve.edu.lv251.dao;

import com.softserve.edu.lv251.entity.Appointments;

import java.util.Date;
import java.util.List;

/**
 * Created by Taras on 16.07.2017.
 */
public interface AppointmentsDAO extends BaseDAO<Appointments>{
    List<Appointments> getAppointmentByDoctorsEmailAfterSomeDate(String email, Date date);

    List<Appointments> appointmentsWithDoctor (Long id);


    List getAppiontmentbyDoctorsEmail(String email);

    List<Appointments> getAppointmentByUserEmail(String email);
}
