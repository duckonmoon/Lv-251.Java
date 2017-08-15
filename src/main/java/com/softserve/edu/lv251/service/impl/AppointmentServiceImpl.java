package com.softserve.edu.lv251.service.impl;

import com.softserve.edu.lv251.config.Mapper;
import com.softserve.edu.lv251.dao.AppointmentsDAO;
import com.softserve.edu.lv251.dto.pojos.AppointmentDTO;
import com.softserve.edu.lv251.dto.pojos.AppointmentsForCreationDTO;
import com.softserve.edu.lv251.dto.pojos.AppointmentsForDateTimePickerInDocDTO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.service.AppointmentService;
import com.softserve.edu.lv251.service.DoctorsService;
import com.softserve.edu.lv251.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kilopo on 31.07.2017.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentsDAO appointmentsDAO;

    @Autowired
    private DoctorsService doctorsService;

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper mapper;

    @Autowired
    Logger logger;

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
                .filter(p -> p.getDoctors().getId() == doctorId)
                .filter(p -> p.getIsApproved())
                .filter(p -> p.getAppointmentDate().after(new Date()))
                .forEach(p -> appointmentsForCreationDTOS.add(mapper.map(p, AppointmentsForCreationDTO.class)));

        return appointmentsForCreationDTOS;

    }

    @Override
    public List<AppointmentsForCreationDTO> getAllDoctorsAppointmentsAfterNow() {
        List<AppointmentsForCreationDTO> appointmentsForCreationDTOS = new ArrayList<>();
        appointmentsDAO.getAllEntities()
                .stream()
                .filter(Appointments::getIsApproved)
                .filter(p -> p.getAppointmentDate().after(new Date()))
                .forEach(p -> appointmentsForCreationDTOS.add(mapper.map(p, AppointmentsForCreationDTO.class)));
        return appointmentsForCreationDTOS;
    }

    @Override
    public List<AppointmentsForDateTimePickerInDocDTO> getAllDoctorsAppointmentsAfterNow(String email, Date date) {
        List<AppointmentsForDateTimePickerInDocDTO> appointmentsForDateTimePickerInDocDTOS = new LinkedList<>();
        for (Appointments a :
                appointmentsDAO.getAppointmentByDoctorsEmailAfterSomeDate(email, date)) {
            AppointmentsForDateTimePickerInDocDTO appointmentsForDateTimePickerInDocDTO = new AppointmentsForDateTimePickerInDocDTO();
            mapper.map(a, appointmentsForDateTimePickerInDocDTO);
            appointmentsForDateTimePickerInDocDTOS.add(appointmentsForDateTimePickerInDocDTO);
        }
        return appointmentsForDateTimePickerInDocDTOS;
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

        for (Appointments appointment : appointmentsDAO.getAppointmentByUserEmail(email)) {
            AppointmentDTO res = new AppointmentDTO();
            mapper.map(appointment, res);
            results.add(res);
        }
        return results;
    }

    public boolean createAppointment (String localdate, String userEmail, long doctorId){
        Date date;

        SimpleDateFormat isoFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            date = isoFormat.parse(localdate);
            if (date.before(new Date())) {
                return false;
            }

            boolean appointments1 = listAppointmensWithDoctor(doctorId)
                    .stream()
                    .anyMatch(p -> p.getIsApproved() && p.getAppointmentDate().getTime() == date.getTime());

            if(appointments1){
                return false;
            }

            Appointments appointments = new Appointments();
            appointments.setAppointmentDate(date);
            appointments.setIsApproved(false);
            appointments.setUsers(userService.findByEmail(userEmail));
            appointments.setDoctors(doctorsService.find(doctorId));
            addAppointment(appointments);
        } catch (ParseException e) {
            logger.info(e);
            return false;
        }
        return true;

    }
}
