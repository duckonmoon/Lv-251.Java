package com.softserve.edu.lv251.service;

import com.softserve.edu.lv251.dto.pojos.AppointmentsForCreationDTO;
import com.softserve.edu.lv251.dto.pojos.AppointmentDTO;
import com.softserve.edu.lv251.dto.pojos.AppointmentsForDateTimePickerInDocDTO;
import com.softserve.edu.lv251.entity.Appointments;

import java.util.Date;
import java.util.List;

/**
 * Created by kilopo on 31.07.2017.
 */
public interface AppointmentService {

    void addAppointment(Appointments appointments);

    void updateAppointment(Appointments appointments);

    Appointments getAppointmentById(Long id);

    List<AppointmentsForCreationDTO> getAllDoctorAppointmentsAfterNow(long doctorId);

    List<AppointmentsForCreationDTO> getAllDoctorsAppointmentsAfterNow();

    List<AppointmentsForDateTimePickerInDocDTO> getAllDoctorsAppointmentsAfterNow(String email, Date date);

    List<Appointments> listAppointmensWithDoctor(Long id);

    List<Appointments> getAppiontmentbyDoctorsEmail(String email);

    List<AppointmentDTO> getAppointmentByUserEmail(String email);
}
