package com.softserve.edu.lv251.service;

import com.softserve.edu.lv251.dto.pojos.PatientDTO;
import com.softserve.edu.lv251.dto.pojos.UserDTO;
import com.softserve.edu.lv251.entity.Appointments;
import com.softserve.edu.lv251.entity.Doctors;
import com.softserve.edu.lv251.exceptions.EmailExistsException;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 21.07.2017.
 */
public interface DoctorsService {
    void  addDoctor(Doctors doctors);
    List<Doctors> getAll();
    void update(Doctors doctors);
    Doctors find(long id);
    void delete(Doctors doctors);
    List searchByLetters(String search);
    List<Doctors> getDoctorsByColumnNameAndValue(String columnName, Object value);
    public Doctors findByEmail(String email);
    public Doctors registerNewDoctorAccount(UserDTO accountDto) throws EmailExistsException;
    List<Appointments> appointmentsInThisMonth(Long id, Date date);
    List<Doctors>searchByDistrict(String name);
    List<Doctors>searchBySpecialization(String name);
    List<PatientDTO> getDoctorPatients(long doctorId);

}
