package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dao.AppointmentsDAO;
import com.softserve.edu.lv251.dto.pojos.AppointmentsForCreationDTO;
import com.softserve.edu.lv251.dto.pojos.AppointmentDTO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kilopo on 31.07.2017.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentsDAO appointmentsDAO;

    @Autowired
    private Mapper mapper;

    @Override
    public void addAppointment(Appointments appointments) {
        appointmentsDAO.addEntity(appointments);
    }

    @Override
    public void updateAppointment(Appointments appointments) {
        appointmentsDAO.updateEntity(appointments);
    }

    @Override
    public Appointments getAppointmentById(Long id) {
        return appointmentsDAO.getEntityByID(id);
    }

    @Override
    public List<AppointmentsForCreationDTO> getAllDoctorAppointmentsAfterNow(long doctorId) {
        List<AppointmentsForCreationDTO> appointmentsForCreationDTOS = new ArrayList<>();
        appointmentsDAO.getAllEntities()
                .stream()
                .filter(p->p.getDoctors().getId() == doctorId)
                .filter(p->p.getAppointmentDate().after(new Date()))
                .forEach(p-> appointmentsForCreationDTOS.add(mapper.map(p,AppointmentsForCreationDTO.class)));
        return appointmentsForCreationDTOS;

    }

    @Override
    public List<AppointmentsForCreationDTO> getAllDoctorsAppointmentsAfterNow() {
        List<AppointmentsForCreationDTO> appointmentsForCreationDTOS = new ArrayList<>();
        appointmentsDAO.getAllEntities()
                .stream()
                .filter(p->p.getAppointmentDate().after(new Date()))
                .forEach(p-> appointmentsForCreationDTOS.add(mapper.map(p,AppointmentsForCreationDTO.class)));
        return appointmentsForCreationDTOS;
    }

    public List<Appointments> listAppointmensWithDoctor(Long id) {
        return appointmentsDAO.appointmentsWithDoctor(id);
    }

    public List<Appointments> getAppiontmentbyDoctorsEmail(String email) {
        return appointmentsDAO.getAppiontmentbyDoctorsEmail(email);
    }

    @Override
    public List<AppointmentDTO> getAppointmentByUserEmail(String email) {
        List<AppointmentDTO> results = new ArrayList<>();

        for (Appointments appointment: appointmentsDAO.getAppointmentByUserEmail(email)){
            AppointmentDTO res = new AppointmentDTO();
            mapper.map(appointment, res);
            results.add(res);
        }
        return results;
    }

}
