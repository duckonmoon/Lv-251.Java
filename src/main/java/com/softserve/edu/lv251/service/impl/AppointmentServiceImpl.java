package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.dao.AppointmentsDAO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kilopo on 31.07.2017.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentsDAO appointmentsDAO;

    @Override
    public void addAppointment(Appointments appointments) {
        appointmentsDAO.addEntity(appointments);
    }

    @Override
    public void updateAppointment(Appointments appointments) {
        appointmentsDAO.updateEntity(appointments);
    }

    @Override
    public Appointments getAppointmentById(long id) {
        return appointmentsDAO.getEntityByID(id);
    }

    @Override
    public List<Appointments> listAppointmensWithDoctor() {
        return appointmentsDAO.appointmentsWithDoctor();
    }

}
